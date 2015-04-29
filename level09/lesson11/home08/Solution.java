package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.Random;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] firstArray = new int[5];
        int[] secondArray = new int[2];
        int[] thirdArray = new int[4];
        int[] fourthArray = new int[7];
        int[] fifthArray = new int[0];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = new Random().nextInt();
        }
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = new Random().nextInt();
        }
        for (int i = 0; i < thirdArray.length; i++) {
            thirdArray[i] = new Random().nextInt();
        }
        for (int i = 0; i < fourthArray.length; i++) {
            fourthArray[i] = new Random().nextInt();
        }
        for (int i = 0; i < fifthArray.length; i++) {
            fifthArray[i] = new Random().nextInt();
        }

        list.add(firstArray);
        list.add(secondArray);
        list.add(thirdArray);
        list.add(fourthArray);
        list.add(fifthArray);

        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
