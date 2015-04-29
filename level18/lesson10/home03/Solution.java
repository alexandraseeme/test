package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream fileInputStream2 = new FileInputStream(file2);
        FileInputStream fileInputStream3 = new FileInputStream(file3);
        FileOutputStream fileOutputStream = new FileOutputStream(file1);

        byte[] buffer = new byte[fileInputStream2.available()];
        if (fileInputStream2.available() > 0) {

            int count = fileInputStream2.read(buffer);
            fileOutputStream.write(buffer, 0, count);
        }

        byte[] buffer1 = new byte[fileInputStream3.available()];
        if (fileInputStream3.available() > 0) {

            int count = fileInputStream3.read(buffer1);
            fileOutputStream.write(buffer1, 0, count);
        }

        reader.close();
        fileInputStream2.close();
        fileInputStream3.close();
        fileOutputStream.close();
    }
}
