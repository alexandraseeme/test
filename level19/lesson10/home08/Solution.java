package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        ArrayList<String> lines = new ArrayList<String>();

        while (reader.ready()){
            lines.add(reader.readLine());
        }

        reader.close();

        for (String line : lines) {
            StringBuilder stringBuilder = new StringBuilder(line);
            stringBuilder.reverse();
            System.out.println(stringBuilder.toString());
        }

    }
}
