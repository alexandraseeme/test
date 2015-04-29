package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(5, 5, value);
    }

    public static void printMatrix(int m, int n) {
        printMatrix(m, n, "default ");
    }

    public static void printMatrix(int m) {
        printMatrix(m, m, "default");
    }

    public static void printMatrix(int m,  Object value) {
        printMatrix(m, m, (Object) value);
    }

    public static void printMatrix(Object value) {
        printMatrix(5, 5, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value, boolean withSpace) {
        if(withSpace) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(value);
                }
                System.out.println();
            }
        }
    }

    public static void printMatrix(int m, int n, String value, boolean withSpace) {
        if(withSpace) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(value);
                }
                System.out.println();
            }
        }
    }

    public static void printMatrix(int m, boolean withSpace) {
        printMatrix(m, m, "default", withSpace);
    }

}
