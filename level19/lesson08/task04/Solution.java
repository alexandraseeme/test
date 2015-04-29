package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        PrintStream initialValue = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream adapter = new PrintStream(byteArrayOutputStream);

        System.setOut(adapter);

        testString.printSomething();

        System.setOut(initialValue);

        String s = byteArrayOutputStream.toString();

        int i = 0;

        String patternString = "\\d+";

        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(s);

        ArrayList<Integer> integers = new ArrayList<Integer>();
        while(matcher.find()){
            String digit = s.substring(matcher.start(), matcher.end());
            integers.add(Integer.parseInt(digit));
        }

        char operation = ' ';

        for (int j = 0; j < s.toCharArray().length; j++) {
            if (s.charAt(j) == '+' || s.charAt(j) == '-' || s.charAt(j) == '*'){
                operation = s.charAt(j);
                break;
            }
        }

        int a = integers.get(0);
        int b = integers.get(1);

        if (operation == '+'){
            i = a + b;
        } else if (operation == '-'){
            i = a - b;
        } else if (operation == '*'){
            i = a * b;
        }

        String result = s.trim().concat(" " + i);

        System.out.println(result);

        byteArrayOutputStream.close();
        adapter.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("20 - 19 = ");
        }
    }
}

