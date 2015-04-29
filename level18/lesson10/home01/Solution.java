package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        int count=0;

        while(inputStream.available() > 0){
            char someChar = (char) inputStream.read();

            for (int i = 0; i < alphabet.length; i++) {
                if (someChar == alphabet[i]){
                    count++;
                }
            }
        }

        System.out.println(count);

        inputStream.close();
    }
}
