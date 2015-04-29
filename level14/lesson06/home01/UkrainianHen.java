package com.javarush.test.level14.lesson06.home01;

/**
 * Created by y10871 on 07.04.2015.
 */
public class UkrainianHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 50;
    }

    @Override
    String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.UKRAINE +". Я несу "+ this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
