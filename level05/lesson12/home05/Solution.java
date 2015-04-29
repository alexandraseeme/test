package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean isExit = true;
        int sum=0;

        while(isExit) {
           String s1 = br.readLine();
           if (s1.equals("сумма")){
               isExit = false;
               System.out.println(sum);
           }
            try {
                sum = sum + Integer.parseInt(s1);
            } catch (NumberFormatException e){

            }
        }

    }
}
