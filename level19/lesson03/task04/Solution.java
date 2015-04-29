package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            Person person;
            String s = null;
            if(scanner.hasNextLine()){
                s=scanner.nextLine();
            }
            String[] array = s.split(" ");
            String firstName = array[1];
            String middleName = array[2];
            String lastName = array[0];

            Calendar calendar = new GregorianCalendar(Integer.parseInt(array[5]), Integer.parseInt(array[4])-1, Integer.parseInt(array[3]) );
            Date birthDate = calendar.getTime();

            person = new Person(firstName, middleName, lastName, birthDate);
            return person;
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}
