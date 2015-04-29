package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char[] array = s.toCharArray();
        ArrayList<Character> arrayVowels = new ArrayList<Character>();
        ArrayList<Character> arrayOthers = new ArrayList<Character>();

        for (int i = 0; i < array.length; i++) {
            if (isVowel(array[i])){
                arrayVowels.add(array[i]);
            } else if (!Character.isWhitespace(array[i])) {
                arrayOthers.add(array[i]);
            }
        }
        for (Character arrayVowel : arrayVowels) {
            System.out.print(arrayVowel + " ");
        }
        System.out.println("");
        for (Character arrayOther : arrayOthers) {
            System.out.print(arrayOther + " ");
        }

    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
