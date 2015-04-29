package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();

        FileInputStream reader1 = new FileInputStream(fileName1);


        byte[] buffer = new byte[reader1.available()];
        reader1.read(buffer);
        String text = new String(buffer);

        String patternString = "\\b[Ww]orld\\b";

        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(text);

        int count1 = 0;
        while(matcher.find()) {
            count1++;
        }

        System.out.println(count1);
        reader.close();
        reader1.close();
    }
}
