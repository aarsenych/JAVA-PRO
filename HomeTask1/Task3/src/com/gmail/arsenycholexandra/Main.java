package com.gmail.arsenycholexandra;

/*
3. Написать код, который сериализирует и десериализирует в/из файла все значения полей класса, которые
отмечены аннотацией @Save.
*/

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        TestClass human1 = new TestClass("Vasya", 26, "USA");
        File file = new File("/Users/alexandraarsenych/IdeaProjects/JavaPro/HomeTask1/Task3/src/com/gmail/arsenycholexandra/JSON.txt");

        JSON.saveToJSONFile(human1, file);



        }

}

