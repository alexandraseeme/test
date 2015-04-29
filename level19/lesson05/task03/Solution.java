package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);

        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        String text = new String(buffer);

        String patternString = "\\b\\d+\\b";

        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(text);

        ArrayList<String> strings = new ArrayList<String>();
        while(matcher.find()){
            strings.add(text.substring(matcher.start(), matcher.end()));
        }


        for (String string : strings) {
            fileOutputStream.write(string.getBytes());
            fileOutputStream.write(' ');
        }
        reader.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
