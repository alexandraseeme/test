package com.javarush.test.level19.lesson10.home04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        ArrayList<String> lines = new ArrayList<String>();

        while (reader.ready()) {
            lines.add(reader.readLine());
        }

        reader.close();

        for (String line : lines) {
            int count = 0;

            for (int i = 0; i < words.size(); i++) {
                String patternString = "\\b" +
                        words.get(i) +
                        "\\b";

                Pattern pattern = Pattern.compile(patternString);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    count++;
                }

            }
            if (count == 2) {
                System.out.println(line);
            }
        }
        //c:\Users\Y10871.EUR\Desktop\adsdocs\result.txt
    }
}
