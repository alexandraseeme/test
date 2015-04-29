package com.javarush.test.level15.lesson04.task03;

/* ООП - Перегрузка - убираем лишнее
1. Подумайте, какая из реализаций метода print будет вызвана.
2. Удалите все лишние реализации метода print.
*/

public class Solution {
    public static void main(String[] args) {
        print(1);
    }
/*
    byte к short, int, long, float или double
    short к int, long, float или double
    char к int, long, float или double
    int к long, float или double
    long к float или double
    float к double

 */
   /* public static void print(byte b) {
        System.out.println("Я буду Java прогером!");
    }
*/
   /* public static void print(double d) {
        System.out.println("Я буду Java прогером!");
    }
*/
    public static void print(long l) {
        System.out.println("Я буду Java прогером!");
    }

    /*public static void print(float f) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(char c) {
        System.out.println("Я буду Java прогером!");
    }*/
}
