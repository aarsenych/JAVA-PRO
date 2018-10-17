package com.gmail.arsenycholexandra;

/*
3. Написать код, который сериализирует и десериализирует в/из файла все значения полей класса, которые
отмечены аннотацией @Save.
*/

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TestClass human1 = new TestClass("Vasya", "USA");
        File file = new File("/Users/alexandraarsenych/IdeaProjects/JavaPro/HomeTask1/Task3/src/com/gmail/arsenycholexandra/Serialization.txt");

        try {
            Serialization.saveToJSON(human1, file);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.print(Serialization.loadFromJSONFile(file));
    }

}

