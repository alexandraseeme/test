package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

        ArrayList<String> lines = new ArrayList<String>();

        while(reader.ready()){
            lines.add(reader.readLine());
        }

        reader.close();

        FileWriter fileWriter = new FileWriter(args[1]);

        ArrayList<String> result = new ArrayList<String>();

        for (String line : lines) {
            String[] array = line.split(" ");
            for (String s : array) {
                if (s.length() > 6){
                    result.add(s);
                }
            }
        }

        if (result.size() > 1) {
            for (int i = 0; i <= result.size() - 2; i++) {
                fileWriter.write(result.get(i) + ",");
            }
        }
        fileWriter.write(result.get(result.size()-1));

        fileWriter.close();


    }
}
