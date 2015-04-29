package com.javarush.test.level15.lesson12.home05;

/**
 * Created by y10871 on 09.04.2015.
 */
public class SubSolution extends Solution {

    public SubSolution() {
    }

    public SubSolution(String s) {
        super(s);
    }

    public SubSolution(int i) {
        super(i);
    }

    protected SubSolution(Object s) {
        super(s);
    }

    protected SubSolution(Object s, int i) {
        super(s, i);
    }

    protected SubSolution(Object s, double d) {
        super(s, d);
    }

    SubSolution(Number s) {
        super(s);
    }

    SubSolution(Exception s) {
        super(s);
    }

    SubSolution(short s) {
        super(s);
    }

    private SubSolution(String s, int i) {

    }

    private SubSolution(String s, int i, double d) {

    }

    private SubSolution(Object s, int i, double d) {

    }
}
