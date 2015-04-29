package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        while (reader.ready()){
            String s = reader.readLine();
            if (s.startsWith(args[0] + " ")) {
                //String[] array = s.split(" ");
                //System.out.print(Integer.parseInt(array[0]) + " " + array[1] + " " + Double.parseDouble(array[2]) + " " + Integer.parseInt(array[3]));
                System.out.println(s);
                break;
            }
        }

        reader.close();
    }
}
