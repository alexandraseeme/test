package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter outputStream = new FileWriter(reader.readLine());

        ArrayList<String> list = new ArrayList<String>();

        while (true) {
            String s = reader.readLine();
            list.add(s);
            if (s.equals("exit")) {
                for (String str : list) {
                    outputStream.write(str);
                }
                break;
            }
            list.add("\n");
        }

        outputStream.close();
    }
}
