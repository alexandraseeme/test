package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> fileNames = new ArrayList<String>();
        while (true) {
            String fileName = reader.readLine();
            if ("end".equals(fileName))
                break;
            else {
                fileNames.add(fileName);
            }
        }

        sortByPartNumber(fileNames);
        FileOutputStream fileOutputStream = new FileOutputStream(fileNames.get(0).replaceAll(".part\\d+", ""));


        for (int i = 0; i < fileNames.size(); i++) {
            FileInputStream fileInputStream = new FileInputStream(fileNames.get(i));
            byte[] buffer = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            fileOutputStream.write(buffer, 0, count);
            fileInputStream.close();
        }

        fileOutputStream.close();
        reader.close();

     }


    public static int getPartNumber(String s){
        int partNumber;
        String[] array = s.split("\\\\");
        String[] array2 = array[array.length-1].split("\\.");
        partNumber = Integer.parseInt(array2[array2.length-1].replaceAll("[^0-9]", ""));
        return partNumber;
    }

    public static void sortByPartNumber(List<String> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (getPartNumber(list.get(j)) > getPartNumber(list.get(j + 1))) {
                    String holder = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, holder);
                }
            }
        }
    }
}
