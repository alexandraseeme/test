package com.javarush.test.level12.lesson04.task03;

/* Пять методов print с разными параметрами
Написать пять методов print с разными параметрами.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static void print(Integer s){
        System.out.println(s);
    }

    public static void print(int i){
        System.out.println(i);
    }

    public static void print(String s, int i){
        System.out.println(s+i);
    }

    public static void print(String s, String s1){
        System.out.println(s + s1);
    }

    public static void print(ArrayList<String> array){
        for (String s : array) {
            System.out.println(s);
        }
    }
}
