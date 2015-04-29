package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man("Vova", 25, "Lviv");
        Man man2 = new Man("Anton", 30, "Lviv2");

        Woman  w1 = new Woman("Sasha", 29, "MyAddress");
        Woman  w2 = new Woman("Sasha2", 28, "MyAddress2");

        System.out.println(man1.getName() + " " + man1.getAge() + " " + man1.getAddress());
        System.out.println(man2.getName() + " " + man2.getAge() + " " + man2.getAddress());
        System.out.println(w1.getName() + " " + w1.getAge() + " " + w1.getAddress());
        System.out.println(w2.getName() + " " + w2.getAge() + " " + w2.getAddress());


        // Выведи их на экран тут
    }

    public static class Man{
        public String name;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public  int age;
        public String address;

        public Man(String name){
            this.name = name;
        }

        public Man(String name, int age){
            this.name = name;
            this.age = age;
        }

        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    public static class Woman{
        public String name;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public  int age;
        public String address;

        public Woman(String name){
            this.name = name;
        }

        public Woman(String name, int age){
            this.name = name;
            this.age = age;
        }

        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}
