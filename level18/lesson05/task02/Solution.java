package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);

        int count = 0;
        char c = ',';
        while (fileInputStream.available() > 0) {
            if (fileInputStream.read() == (int) c) {
                count++;
            }
        }

        System.out.println(count);

        reader.close();
        fileInputStream.close();

    }
}
