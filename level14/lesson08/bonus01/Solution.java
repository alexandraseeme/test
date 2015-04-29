package com.javarush.test.level14.lesson08.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception

        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //it's second exception
        String s = null;
        try {
            s.toCharArray();
        } catch (Exception e) {
            exceptions.add(e);
        }

        //it's third exception
        try {
            String s1 = "sss";
            int i = Integer.parseInt(s1);
        } catch (Exception e) {
            exceptions.add(e);
        }

        //it's fourth exception
        String[] array = new String[]{"test", "one"};
        try {
            String newStr = array[5];
        } catch (Exception e) {
            exceptions.add(e);
        }

        //it's fifth exception
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        try {
            list.remove(5);
        } catch (Exception e) {
            exceptions.add(e);
        }

        //it's sixth exception
        try {
            FileReader reader = new FileReader("C:\\pathDoesNotExist");
        } catch (Exception e) {
            exceptions.add(e);
        }

        //it's seventh exception
        try {
            throw new InvalidClassException("test");
        } catch (Exception e) {
            exceptions.add(e);
        }

        //it's eighth exception
        try {
            throw new UnsupportedOperationException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        //it's ninth exception
        try {
             Date date = new Date("blah");
        } catch (Exception e) {
            exceptions.add(e);
        }

        //it's tenth exception
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }

}
