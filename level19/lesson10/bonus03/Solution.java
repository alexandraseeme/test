package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

/*
долго сидел над задачей, пока в конце концов не взял листок бумаги и не набросал логический ход решения, похоже начались задачи, где сходу кодить уже не всегда выходит (по крайней мере у меня)
дык вобщем задача несложная, я делал следующим образом:
1) создал два списка для индексов (в первый заносил индекс символа начинающего открывающий тег, во второй индекс символа завершающего закрывающий тег)
2) потом шел по файлу и находил нужные теги
— если тег открывающий, то заносил в список открывающих тегов индекс его первого символа, а в списке закрывающих тегов создавал запись со значением нал;
— если же тег закрывающий, то искал в списке закрывающих индексов последнюю нал запись и сетил ей значения индекса завершающего закрывающий тег
3) ну и таким образом у нас получились два списка с индексами начала и концов отрезков, вывести содержимое файла в этих рамках уже не составило труда

 */
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String testTag = args[0];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream reader1 = new FileInputStream(fileName);

        ArrayList<String> tags = new ArrayList<>();

        String openingTag = "<" + testTag;
        String closingTag = "</" + testTag + ">";

        byte[] buffer = new byte[reader1.available()];
        reader1.read(buffer);
        String text = new String(buffer);
        reader1.close();

        ArrayList<Integer> indexesOfOpeningTags = new ArrayList<>();
        ArrayList<Integer> indexesOfClosingTags = new ArrayList<>();
        for (int i = 0; i <= text.length() - closingTag.length(); i++) {
            if (openingTag.equals(text.substring(i, i + openingTag.length()))) {
                indexesOfOpeningTags.add(i);
                indexesOfClosingTags.add(null);
            } else if (closingTag.equals(text.substring(i, i + closingTag.length()))) {
                for (int j = indexesOfClosingTags.size() - 1; j >= 0; j--) {
                    if (indexesOfClosingTags.get(j) == null) {
                        indexesOfClosingTags.set(j, i + closingTag.length());
                        break;
                    }
                }
            }
        }


        for (int i = 0; i < indexesOfOpeningTags.size(); i++) {
            tags.add(text.substring(indexesOfOpeningTags.get(i), indexesOfClosingTags.get(i)));
        }


        for (String tag : tags) {
            String s1 = tag.replaceAll("\\r?\\n", "");
            System.out.println(s1);
        }


    }
}
