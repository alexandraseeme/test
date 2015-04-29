package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static{
        labels.put(23.5, "str1");
        labels.put(11.1, "str2");
        labels.put(88.44, "str3");
        labels.put(32.0, "str4");
        labels.put(1.0, "str5");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
