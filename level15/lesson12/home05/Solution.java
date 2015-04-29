package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution() {
    }

    public Solution(String s) {
    }

    public Solution(int i) {
    }

    private Solution(String s, int i) {

    }

    private Solution(String s, int i, double d) {

    }

    private Solution(Object s, int i, double d) {

    }

    protected Solution(Object s) {
    }

    protected Solution(Object s, int i) {
    }

    protected Solution(Object s, double d) {
    }

    Solution(Number s) {
    }

    Solution(Exception s) {
    }

    Solution(short s) {
    }
}

