package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {

    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new Solution.String();   //string #1
            object.string2 = new Solution.String();   //string #2
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new Solution.String(); //string #3
            loadedObject.string2 = new Solution.String(); //string #4


            loadedObject.load(inputStream);
            loadedObject.string1.print();
            loadedObject.string2.print();

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public Solution.String string1;
        public Solution.String string2;

        public void save(OutputStream outputStream) throws Exception {
            PrintStream holder = System.out;
            PrintStream adapter = new PrintStream(outputStream);
            System.setOut(adapter);
            java.lang.String string1NotEmpty = string1 != null ? "yes" : "no";
            System.out.println(string1NotEmpty);
            if (string1 != null)
                string1.print();

            java.lang.String string2NotEmpty = string1 != null ? "yes" : "no";
            System.out.println(string2NotEmpty);
            if (string2 != null)
                string2.print();
            System.setOut(holder);
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            java.lang.String string1NotEmpty = reader.readLine();
            int holder = countStrings;
            if (string1NotEmpty.equals("yes")) {
                countStrings = Integer.parseInt(reader.readLine().replaceAll("string #", "")) - 1;
                string1 = new Solution.String();
                countStrings = holder;
            }

            java.lang.String string2NotEmpty = reader.readLine();
            if (string2NotEmpty.equals("yes")) {
                countStrings = Integer.parseInt(reader.readLine().replaceAll("string #", "")) - 1;
                string2 = new Solution.String();
                countStrings = holder;

            }

        }
    }

    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
