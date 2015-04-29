package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);

        int[] col = {a,b,c};

        System.out.println(maxInt(col));
        System.out.println(compare(a,b,c));
        System.out.println(minInt(col));
    }

    public static int maxInt(int a, int b) {
        int max;
        if (a > b) {
            max = a;
        } else {
            max = b;
        }
        return max;
    }

    public static int maxInt(int[] ints) {
        int max = ints[1];
        int max1;
        int result = 0;
        for (int i = 0; i < ints.length -1; i++) {
            max1=max;
            max = maxInt(ints[i], ints[i+1]);
            if (max >= max1){
                result = max;
            }
        }
        return result;
    }

    public static int minInt(int a, int b) {
        int min;
        if (a < b) {
            min = a;
        } else {
            min = b;
        }
        return min;
    }

    public static int minInt(int[] ints) {
        int min = ints[1];
        int min1;
        int result = 0;
        for (int i = 0; i < ints.length -1; i++) {
            min1=min;
            min = minInt(ints[i], ints[i + 1]);
            if (min <= min1){
                result = min;
            }
        }
        return result;
    }

    public static int compare(int a, int b, int c){
        int[] col = {a,b,c};

        if (a != minInt(col) && a !=maxInt(col)){
            return a;
        } else
        if (b != minInt(col) && b !=maxInt(col)){
            return b;
        } else
        if (c != minInt(col) && c !=maxInt(col)){
            return c;
        }
        return 0;
    }

}
