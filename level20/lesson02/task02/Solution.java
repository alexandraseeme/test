package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("c:\\Users\\Y10871.EUR\\Desktop\\adsdocs\\result.txt");
            InputStream inputStream = new FileInputStream("c:\\Users\\Y10871.EUR\\Desktop\\adsdocs\\result.txt");

            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setCountry(User.Country.UKRAINE);
            user1.setMale(false);
            user1.setBirthDate(new Date());
            user1.setFirstName("Alex");
            user1.setLastName("Bond");

            User user2 = new User();
            user2.setCountry(User.Country.OTHER);
            user2.setMale(true);
            user2.setBirthDate(new Date());
            user2.setFirstName("Test");
            user2.setLastName("Male");


            User[] users = new User[]{user1, user2};
            javaRush.users.addAll(Arrays.asList(users));

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            for (int i = 0; i <loadedObject.users.size() ; i++) {
                User user = loadedObject.users.get(i);
                System.out.println(user.getBirthDate());
                System.out.println(user.getFirstName());
                System.out.println(user.getLastName());
                System.out.println(user.getCountry().getDisplayedName());
                System.out.println(String.valueOf(user.isMale()));
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            String isUsersAssigned = users != null ? "yes" : "no";
            printWriter.println(isUsersAssigned);
            if (users != null) {
                for (User user : users) {
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM dd yyyy");
                    printWriter.println(simpleDateFormat.format(user.getBirthDate()).toString());
                    printWriter.println(user.getCountry().getDisplayedName());
                    printWriter.println(String.valueOf(user.isMale()));
                }
            }

            printWriter.flush();
            printWriter.close();

        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUsersAssigned = reader.readLine();
            if (isUsersAssigned.equals("yes")) {
                while (reader.ready()) {
                    User user = new User();
                    String userName = reader.readLine();
                    if (userName != null) {
                        user.setFirstName(userName);
                    }
                    String lastName = reader.readLine();
                    if (lastName != null)
                        user.setLastName(lastName);

                    String birthDateStr = reader.readLine();
                    String[] parsed = birthDateStr.split(" ");
                    Calendar calendar = new GregorianCalendar(Integer.parseInt(parsed[2]), Integer.parseInt(parsed[0]) -1, Integer.parseInt(parsed[1]));
                    Date birthDate = calendar.getTime();
                    if (birthDate != null)
                        user.setBirthDate(birthDate);

                    String countryString = reader.readLine();
                    if (countryString != null) {
                        switch (countryString) {
                            case "Ukraine":
                                user.setCountry(User.Country.UKRAINE);
                                break;
                            case "Russia":
                                user.setCountry(User.Country.RUSSIA);
                                break;
                            case "Other":
                                user.setCountry(User.Country.OTHER);
                                break;
                        }
                    }

                    String male = reader.readLine();
                    if (male != null) {
                        switch (male) {
                            case "false":
                                user.setMale(false);
                                break;
                            case "true":
                                user.setMale(true);
                                break;
                        }
                    }
                    users.add(user);
                }

                reader.close();
            }
        }
    }
}
