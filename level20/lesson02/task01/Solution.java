package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("c:\\Users\\Y10871.EUR\\Desktop\\adsdocs\\result.txt");


            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            System.out.println(ivanov.name);
            List<Asset> list = ivanov.assets;
            for (Asset asset : list) {
                System.out.println(asset.getName());
            }
            ivanov.save(outputStream);
            outputStream.flush();

            outputStream.close();

            InputStream inputStream = new FileInputStream("c:\\Users\\Y10871.EUR\\Desktop\\adsdocs\\result.txt");
            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(somePerson.name);
            List<Asset> list1 = somePerson.assets;
            for (Asset asset : list1) {
                System.out.println(asset.getName());
            }

            if (ivanov.equals(somePerson))
                System.out.println("WE WON");
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            String isNamePresent = assets != null ? "yes" : "no";
            printWriter.println(isNamePresent);
            if (name != null) {
                printWriter.println(this.name);
            }

            String isAssetPresent = assets != null ? "yes" : "no";
            printWriter.println(isAssetPresent);
            if (assets != null) {
                for (Asset asset : assets) {
                    printWriter.println(asset.getName());
                }
            }
            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isNamePresent = reader.readLine();
            if (isNamePresent.equals("yes")) {
                this.name = reader.readLine();
            }
            String isAssetPresent = reader.readLine();
            if (isAssetPresent.equals("yes")) {
                while (reader.ready()) {
                    String asset = reader.readLine();
                    if (asset != null) {
                        assets.add(new Asset(asset));
                    }
                }
            }
            reader.close();
        }
    }
}
