package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
/*
в общем можно не париться. проходит и решение, где просто парс и приведение к формату вывода.
1) maxID можно вычислить еще на этапе считывания строк из файла, зачем гонять цикл второй раз?
2) Входные данные уже изначально хранятся в удобном для обработки виде (массив). Зачем собирать из них строку в createLine, чтобы потом в createRec ее заново парсить?
3) В своем коде не нашел чтобы я округлял цену или учитывал переполнения maxID, прошло без этого, нужно ли или нет, не знаю.
Так же, нужно учитывать что productName может состоять из нескольких слов (внутри несколько пробелов) и во входных данных количество символов в поле может быть больше чем необходимо.
 */

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

       String id = setNewID(fileName);

        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);


        String productName = setProductName(args);
        String price = setPrice(Double.parseDouble(args[args.length - 2]));
        String quantity = setQuantity(Integer.parseInt(args[args.length - 1]));

        String line = id + productName.toString() + price + quantity;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        stringBuilder.append(line);

       if (args[0].equals("-c")){
            fileOutputStream.write(stringBuilder.toString().getBytes());
        }
        fileOutputStream.close();
    }

    public static int getLastID(String fileName) throws IOException {
        int maxID = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        while (reader.ready()){
           String s = reader.readLine();
            if (s.length() > 8) {
                try {
                    int index = Integer.parseInt(s.substring(0, 8).trim());
                    if (index > maxID)
                        maxID = index;
                } catch (NumberFormatException e) {
                    //do not do anything, read next line
                }
            }
        }
        reader.close();

        return maxID;
    }

    public static String setNewID(String filename) throws IOException {
        int maxID = getLastID(filename) + 1;
        String newID = maxID + "";
        char[] array = newID.toCharArray();
        if (array.length < 8){
            char[] array2 = new char[8];
            for (int i = 0; i < array.length; i++) {
                array2[i] = array[i];
            }

            for (int i = array.length; i < 8; i++) {
                array2[i] = ' ';
            }
            newID = new String(array2);
        }

        return newID;
    }

    public static String setProductName(String[] args){
        String productName = null;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < args.length - 2 ; i++) {
            stringBuilder.append(args[i] + " ");
        }

        productName = stringBuilder.toString();

        char[] array = productName.toCharArray();
        if (array.length < 30){
            char[] newArray = new char[30];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }

            for (int i = array.length; i < 30; i++) {
                newArray[i] = ' ';
            }
            productName = new String(newArray);

        } else if (array.length > 30) {
            char[] newArray = new char[30];
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = array[i];
            }
            productName = new String(newArray);
        }

        return productName;

    }

    public static String setPrice(double price){
        String newPrice = price + "";
        char[] array = newPrice.toCharArray();
        if (array.length < 8){
            char[] array2 = new char[8];
            for (int i = 0; i < array.length; i++) {
                array2[i] = array[i];
            }

            for (int i = array.length; i < 8; i++) {
                array2[i] = ' ';
            }
            newPrice = new String(array2);
        } else if (array.length > 8){
            char[] array2 = new char[8];
            for (int i = 0; i < array2.length; i++) {
                array2[i] = array[i];
            }
            newPrice = new String(array2);
        }

        return newPrice;
    }

    public static String setQuantity(int quantity){
        String newQuantity = quantity + "";
        char[] array = newQuantity.toCharArray();
        if (array.length < 4){
            char[] array2 = new char[4];
            for (int i = 0; i < array.length; i++) {
                array2[i] = array[i];
            }

            for (int i = array.length; i < 4; i++) {
                array2[i] = ' ';
            }
            newQuantity = new String(array2);
        } else if (array.length > 4){
            char[] array2 = new char[4];
            for (int i = 0; i < array2.length; i++) {
                array2[i] = array[i];
            }
            newQuantity = new String(array2);
        }

        return newQuantity;
    }
}
