package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader inputStream = new BufferedReader(new FileReader(reader.readLine()));

        ArrayList<Integer> list = new ArrayList<Integer>();
        while(inputStream.ready()){
            list.add(Integer.parseInt(inputStream.readLine()));
        }

        ArrayList<Integer> even = new ArrayList<Integer>();
        for (Integer integer : list) {
            if (integer %2 == 0)
                even.add(integer);
        }

        for (int i = even.size()-1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (even.get(j) > even.get(j+1)){
                    int holder = even.get(j);
                    even.set(j, even.get(j+1));
                    even.set(j+1, holder);
                }
            }
        }

        for (Integer integer : even) {
            System.out.println(integer);
        }
    }
}
