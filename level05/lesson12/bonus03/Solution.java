package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        int counter = Integer.parseInt(s1);
        if (counter > 0) {
            ArrayList<Integer> myCol = new ArrayList<Integer>();

            while (counter > 0) {
                int colElem = Integer.parseInt(reader.readLine());
                myCol.add(colElem);
                counter--;
            }

            int maximum = maxOutOfAll(myCol);
            System.out.println(maximum);
        }
    }

    public static int maxOutOfAll(ArrayList<Integer> ints){
        Integer max = ints.get(0);
        for (Integer intEl : ints) {
            if (max < intEl){
                max = intEl;
            }
        }
        return max;
    }
}
