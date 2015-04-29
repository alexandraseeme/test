package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

        ArrayList<String> lines = new ArrayList<String>();

        while(reader.ready()){
            lines.add(reader.readLine());
        }

        reader.close();



        for (String line : lines) {
            StringBuilder stringBuilder1 = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            String[] array = line.split(" ");
            for (int i = 0; i < array.length; i++) {
                try{
                    int k = Integer.parseInt(array[i]);
                    stringBuilder1.append(k + " ");
                } catch (NumberFormatException e){
                    stringBuilder2.append(array[i] + " ");
                }
            }

            String name = stringBuilder2.toString().trim();
            String[] dates = stringBuilder1.toString().split(" ");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(dates[2]), Integer.parseInt(dates[1]) -1, Integer.parseInt(dates[0]));
            Date birthDate = calendar.getTime();
            Person person = new Person(name, birthDate);
            PEOPLE.add(person);
        }

    }

}
