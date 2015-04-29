package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName2);
        FileOutputStream fileOutputStream3 = new FileOutputStream(fileName3);

        byte[] buffer1;
        byte[] buffer2;

        if (fileInputStream1.available() / 2 % 2 == 0) {
            buffer1 = new byte[fileInputStream1.available() / 2];
            buffer2 = new byte[fileInputStream1.available() / 2];
        } else {
            buffer1 = new byte[fileInputStream1.available() / 2 + 1];
            buffer2 = new byte[fileInputStream1.available() / 2];
        }


        int count = fileInputStream1.read(buffer1);
        fileOutputStream2.write(buffer1, 0, count);

        count = fileInputStream1.read(buffer2);
        fileOutputStream3.write(buffer2, 0, count);


    }
}
