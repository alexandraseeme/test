package com.javarush.test.level04.lesson13.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int m = Integer.parseInt(s1);
        int n = Integer.parseInt(s2);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(8);
            }
            System.out.println();

        }

    }
}
