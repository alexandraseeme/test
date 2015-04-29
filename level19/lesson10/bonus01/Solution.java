package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)));
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName2)));

        ArrayList<String> firstFile = new ArrayList<>();
        while (reader2.ready()){
                firstFile.add(reader2.readLine());
        }

        ArrayList<String> secondFile = new ArrayList<>();
        while (reader1.ready()){
            secondFile.add(reader1.readLine());
        }

        reader1.close();
        reader2.close();

        ArrayList<LineItem> same = new ArrayList<>();
        ArrayList<LineItem> removed = new ArrayList<>();
        ArrayList<LineItem> added = new ArrayList<>();

        for (String s : secondFile) {
            if (firstFile.contains(s)){
                same.add(new LineItem(Type.SAME, s));
            } else {
                added.add(new LineItem(Type.ADDED, s));
            }
        }

        for (String s : firstFile) {
            if (!secondFile.contains(s)){
                removed.add(new LineItem(Type.REMOVED, s));
            }
        }

        int addedCount = 0;
        int removedCount = 0;
        for (int i = 0; i < same.size(); i++) {
            lines.add(same.get(i));
            if (i % 2 == 0){
                lines.add(added.get(addedCount));
                addedCount++;
            } else {
                lines.add(removed.get(removedCount));
                removedCount++;
            }
        }

        for (LineItem line : lines)
        {
            System.out.println(line.type.toString() + " " + line.line);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
