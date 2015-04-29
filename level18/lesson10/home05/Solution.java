package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
        String[] tokens = null;
        while(true){
            String s = br.readLine();
            if (s == null)
                break;
            tokens = s.split("\\s+");
        }

        List<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            integers.add((int) Math.round(Double.parseDouble(tokens[i])));
        }

        for (int i = 0; i < integers.size(); i++) {
            fileOutputStream.write((integers.get(i) + " ").getBytes());
        }
    }
}
