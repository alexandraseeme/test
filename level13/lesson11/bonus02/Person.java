package com.javarush.test.level13.lesson11.bonus02;

public class Person implements RepkaItem
{
    public String getName() {
        return name;
    }

    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh)
    {
        this.name = name;
        this.namePadezh = namePadezh;
    }

    @Override
    public String getNamePadezh() {
        return namePadezh;
    }

    public void pull(Person personB){
        System.out.println(this.getName() + " за " + personB.getNamePadezh());
    }
}
