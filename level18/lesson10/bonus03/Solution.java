package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234

1       Шорты пляжные синие           159.00  12
2       Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int id = Integer.parseInt(args[1]);
        String idStr = args[1];


        // c:\Users\Y10871.EUR\Desktop\adsdocs\result1.txt
        if (args[0].equals("-u")) {
            String existingID = setNewID(id);
            String newProductName = setProductName(args);
            String newPrice = setPrice(Double.parseDouble(args[args.length - 2]));
            String newQuantity = setQuantity(Integer.parseInt(args[args.length - 1]));

            String line = existingID + newProductName.toString() + newPrice + newQuantity;

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('\n');
            stringBuilder.append(line);

            String resultLine = stringBuilder.toString();

            RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
            String s = null;
            while (randomAccessFile.getFilePointer() < (randomAccessFile.length() - 1)) {
                long pos = randomAccessFile.getFilePointer();
                s = randomAccessFile.readLine();
                if (s.length() > 8) {
                    try {
                        int index = Integer.parseInt(s.substring(0, 8).trim());
                        if (index == id) {
                            randomAccessFile.seek(pos);
                            for (int i = 0; i < s.length(); i++) {
                                randomAccessFile.write((int) ' ');
                            }
                            randomAccessFile.seek(pos);
                            randomAccessFile.write(resultLine.getBytes());
                            break;
                        }

                    } catch (NumberFormatException e) {
                        //do not do anything, read next line
                    }
                }

            }

        } else if (args[0].equals("-d")) {
            ArrayList<String> stringsFromFile = new ArrayList<String>();
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            while (reader.ready()) {
                String s = reader.readLine();
                stringsFromFile.add(s);
            }
            reader.close();

            for (int i = 0; i < stringsFromFile.size(); i++) {
                if (stringsFromFile.get(i).length() > 8) {
                    String index = stringsFromFile.get(i).substring(0, 8).trim();
                    if (index.equals(idStr)) {
                        stringsFromFile.remove(i);
                        break;
                    }
                }
            }

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            for (int j = 0; j < stringsFromFile.size(); j++) {
                fileOutputStream.write(stringsFromFile.get(j).getBytes());
                fileOutputStream.write(System.getProperty("line.separator").getBytes());
            }
        }
    }

    public static String setNewID(int id) throws IOException {
        int maxID = id;
        String newID = maxID + "";
        char[] array = newID.toCharArray();
        if (array.length < 8) {
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

    public static String getLineByID(int id, String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String s = null;
        while (reader.ready()) {
            s = reader.readLine();
            if (s.length() > 8) {
                try {
                    int index = Integer.parseInt(s.substring(0, 8).trim());
                    if (index == id)
                        return s;
                } catch (NumberFormatException e) {
                    //do not do anything, read next line
                }
            }
        }
        reader.close();
        return s;
    }

    public static String setProductName(String[] args) {
        String productName = null;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i < args.length - 2; i++) {
            stringBuilder.append(args[i] + " ");
        }

        productName = stringBuilder.toString();

        char[] array = productName.toCharArray();
        if (array.length < 30) {
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

    public static String getProductName(int id, String fileName) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "r");
        String productName = null;
        while (randomAccessFile.getFilePointer() < (randomAccessFile.length() - 1)) {
            long pos = randomAccessFile.getFilePointer();
            String s = randomAccessFile.readLine();
            if (s.length() > 8) {
                try {
                    int index = Integer.parseInt(s.substring(0, 8).trim());
                    if (index == id)
                        productName = s.substring(8, 37);
                    System.out.println("PRODUCTNAME IS: " + productName);
                    break;

                } catch (NumberFormatException e) {
                    //do not do anything, read next line
                }
            }
        }
        return productName;
    }

    public static String setPrice(double price) {
        String newPrice = price + "";
        char[] array = newPrice.toCharArray();
        if (array.length < 8) {
            char[] array2 = new char[8];
            for (int i = 0; i < array.length; i++) {
                array2[i] = array[i];
            }

            for (int i = array.length; i < 8; i++) {
                array2[i] = ' ';
            }
            newPrice = new String(array2);
        } else if (array.length > 8) {
            char[] array2 = new char[8];
            for (int i = 0; i < array2.length; i++) {
                array2[i] = array[i];
            }
            newPrice = new String(array2);
        }

        return newPrice;
    }

    public static String setQuantity(int quantity) {
        String newQuantity = quantity + "";
        char[] array = newQuantity.toCharArray();
        if (array.length < 4) {
            char[] array2 = new char[4];
            for (int i = 0; i < array.length; i++) {
                array2[i] = array[i];
            }

            for (int i = array.length; i < 4; i++) {
                array2[i] = ' ';
            }
            newQuantity = new String(array2);
        } else if (array.length > 4) {
            char[] array2 = new char[4];
            for (int i = 0; i < array2.length; i++) {
                array2[i] = array[i];
            }
            newQuantity = new String(array2);
        }

        return newQuantity;
    }
}
