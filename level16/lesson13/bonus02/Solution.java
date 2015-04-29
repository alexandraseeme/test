package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new EternalThread());
        threads.add(new InterruptedExceptionThread());
        threads.add(new HurrayThread());
        threads.add(new MessageThread());
        threads.add(new ReadNumbersThread());
    }

    public static class EternalThread extends Thread {
        public void run() {
            while (true) {
            }
        }
    }

    public static class InterruptedExceptionThread extends Thread {
        public void run() {
            try {
                while (!isInterrupted())
                {
                }
                throw new InterruptedException("InterruptedException");
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class HurrayThread extends Thread {
        public void run() {
            while (!isInterrupted()) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
    public static class MessageThread extends Thread implements Message {
        public void run() {
            while (!isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
            try {
                this.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
    public static class ReadNumbersThread extends Thread {
        @Override
        public void run()
        {
            int result = 0;
            String str = null;

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try
            {
                while (!((str = reader.readLine()).equals("N")))
                {
                    result += Integer.parseInt(str);
                }
                System.out.println(result);

            }
            catch (Exception e)
            {
                System.out.println(result);
            }
        }
    }
}
