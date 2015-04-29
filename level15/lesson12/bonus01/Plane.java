package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by y10871 on 10.04.2015.
 */
//2. Класс Plane должен иметь 1 конструктор с параметром int - количество перевозимых пассажиров.
public class Plane implements Flyable {

    int passengers;

    @Override
    public void fly() {

    }

    public Plane(int passengers) {
        this.passengers = passengers;
    }
}
