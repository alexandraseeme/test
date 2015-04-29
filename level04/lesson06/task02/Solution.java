package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        String s4 = br.readLine();

        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);
        int d = Integer.parseInt(s4);

        int[] col = {a,b,c,d};

        System.out.println(maxInt(col));

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
}
