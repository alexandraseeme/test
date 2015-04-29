package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

        double max = 0;
        for (Map.Entry<String,Double> stringDoubleEntry : map.entrySet()) {
            if (max < stringDoubleEntry.getValue()){
                max = stringDoubleEntry.getValue();
            }
        }

        for (Map.Entry<String,Double> stringDoubleEntry : map.entrySet()) {
            if (stringDoubleEntry.getValue().equals(max)){
                System.out.println(stringDoubleEntry.getKey());
            }
        }


        reader.close();
    }
}
