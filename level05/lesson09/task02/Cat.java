package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным.
Например, если вес не известен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    public String name;
    public int weight;
    public int age;
    public String address;
    public String color;

    int DEFAULT_WEIGHT = 5;
    int DEFAULT_AGE = 1;

    public Cat(String name){
        this.name = name;
        this.age = DEFAULT_AGE;
        this.weight = DEFAULT_WEIGHT;
    }

    public Cat(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
        this.weight = DEFAULT_WEIGHT;
    }

    public Cat(int weight, String color){
        this.weight = weight;
        this.color = color;
        this.age = DEFAULT_AGE;
    }

    public Cat(int weight, String color, String address){
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = DEFAULT_AGE;
    }

}
