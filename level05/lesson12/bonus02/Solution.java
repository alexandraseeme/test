package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        int[] ints = {a,b,c,d,e};

        System.out.println("Minimum = " + minOutOfAll(ints));
    }


    public static int min(int a, int b)
    {
        return a < b ? a : b;
    }

    public static int minOutOfAll(int[] ints){
        int min = ints[0];
        for (int i = 0; i < ints.length; i++) {
            if (min > ints[i]){
                min = ints[i];
            }
        }
        return min;
    }

}
