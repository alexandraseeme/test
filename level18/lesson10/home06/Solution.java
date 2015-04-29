package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[0]);

        Map<Character, Integer> map = new TreeMap<Character, Integer>();

        //init map
        for (int i = 0; i <= 255; i++) {
            map.put((char) i, 0);
        }

        while (fileInputStream.available() > 0) {
            char someChar = (char) fileInputStream.read();
            for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
                if (characterIntegerEntry.getKey().equals(someChar)) {
                    characterIntegerEntry.setValue(characterIntegerEntry.getValue() + 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if (characterIntegerEntry.getValue() != 0) {
                System.out.print(characterIntegerEntry.getKey() + " " + characterIntegerEntry.getValue());
                System.out.println("");
            }
        }

        fileInputStream.close();

    }
}
