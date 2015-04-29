package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

/*    public static void main(String[] args) throws Exception {
        fillInPropertiesMap();
        //U:\ALL\trunk\apps\ads-admin\ads-admin-tests\src\test\java\com\aris\client\webtest\ads\data\adsdocument.properties
    *//*    for (Map.Entry<String, String> stringStringEntry : properties.entrySet()) {
            System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue());
        }*//*

        save(new FileOutputStream("c:\\Users\\Y10871.EUR\\Desktop\\adsdocs\\new.properties"));
        load(new FileInputStream("c:\\Users\\Y10871.EUR\\Desktop\\adsdocs\\new.properties"));
        for (Map.Entry<String, String> stringStringEntry : properties.entrySet()) {
            System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue());
        }
    }*/

    public void fillInPropertiesMap() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Properties properties1 = new Properties();
        properties1.load(new FileInputStream(fileName));
        for (Map.Entry<Object, Object> objectObjectEntry : properties1.entrySet()) {
            properties.put(String.valueOf(objectObjectEntry.getKey()), (String) objectObjectEntry.getValue());
        }
        reader.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter printWriter = new PrintWriter(outputStream);
        String isPropertiesMapFilled = properties !=null ? "yes" : "no";
        printWriter.println("#" + isPropertiesMapFilled);
        if (properties !=null) {
            Properties properties1 = new Properties();
            properties1.putAll(properties);
            properties1.store(printWriter, null);
        }
        printWriter.close();
    }

    public void load(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String isPropertiesMapFilled = reader.readLine();
        if (isPropertiesMapFilled.equals("#yes")){
            Properties properties1 = new Properties();
            properties1.load(reader);
            for (Map.Entry<Object, Object> objectObjectEntry : properties1.entrySet()) {
                properties.put(String.valueOf(objectObjectEntry.getKey()), (String) objectObjectEntry.getValue());
            }
        }

    }
}
