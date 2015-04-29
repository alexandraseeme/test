package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);

        while (fileInputStream.available() > 0) {
            int i = fileInputStream.read();
            if ((char) i == '.') {
                fileOutputStream.write((int) '!');
            } else {
                fileOutputStream.write(i);
            }

        }

        fileOutputStream.close();
        fileInputStream.close();
        reader.close();

    }
}
