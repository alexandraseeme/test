package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileInputName = args[1];
        String fileOutputName = args[2];

        FileInputStream fileInputStream = new FileInputStream(fileInputName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);

        if (args[0].startsWith("-e")){
            byte[] buffer = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            fileOutputStream.write(encryptDecrypt(buffer), 0, count);

        } else if (args[0].startsWith("-d")){
            byte[] buffer = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            fileOutputStream.write(encryptDecrypt(buffer), 0, count);
        }
    }

    public static byte[] encryptDecrypt(byte[] b){

        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (255-b[i]);
        }
        return b;
    }

}
