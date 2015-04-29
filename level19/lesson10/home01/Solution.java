package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        Map<String, Double> map = new TreeMap<String, Double>();

        ArrayList<String> lines = new ArrayList<String>();

        while(reader.ready()){
            lines.add(reader.readLine());
        }

        for (String line : lines) {
            String[] output = line.split(" ");
                if (!map.containsKey(output[0])){
                    map.put(output[0], Double.parseDouble(output[1]));
                } else if (map.containsKey(output[0])) {
                    map.put(output[0], map.get(output[0]) + Double.parseDouble(output[1]));
                }

        }

        for (Map.Entry<String,Double> stringDoubleEntry : map.entrySet()) {
            System.out.println(stringDoubleEntry.getKey() + " " + stringDoubleEntry.getValue());
        }

        reader.close();
    }
}
