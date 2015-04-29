package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        try {

            while (true) {
                String fileName = bufferedReader.readLine();
                if (fileName.equals("exit"))
                    break;
                else {
                    list.add(fileName);
                }
            }
            bufferedReader.close();
            for (String s : list) {
                ReadThread readThread = new ReadThread(s);
                readThread.start();
                readThread.join();
            }
        } catch (Exception e) {
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            try {
                FileInputStream fileReader = new FileInputStream(fileName);
                ArrayList<Integer> list = new ArrayList<Integer>();
                while (fileReader.available() > 0) {
                    int data = fileReader.read();
                    list.add(data);
                }
                fileReader.close();

                int max = 0;
                int id = 0;

                for (int a = 0; a < list.size(); a++) {
                    int count = Collections.frequency(list, list.get(a));
                    if (count > max) {
                        max = count;
                        id = list.get(a);
                    }
                }

                resultMap.put(fileName, id);

            } catch (Exception e) {
            }

        }
    }
}
