package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Pattern pattern = Pattern.compile(".*[0-9].*");

        String[] ar = null;
        while (reader.ready()) {
            String s = reader.readLine();
            ar = s.split(" ");

            String str = "";
            for (String anAr : ar) {
                Matcher matcher = pattern.matcher(anAr);
                if (matcher.find()) {
                    outputStream.write((anAr + " ").getBytes());
                }
            }
        }

        inputStream.close();
        outputStream.close();

    }

}
