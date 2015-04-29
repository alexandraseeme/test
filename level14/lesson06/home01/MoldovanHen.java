package com.javarush.test.level14.lesson06.home01;

/**
 * Created by y10871 on 07.04.2015.
 */
public class MoldovanHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 40;
    }

    @Override
    String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA +". Я несу "+ this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
