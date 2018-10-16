package com.gmail.arsenycholexandra;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class JSON {
    public static void saveToJSONFile(TestClass human, File file) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Class<?> clas = human.getClass();
        Field[] fields = clas.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)){
                if(Modifier.isPrivate(field.getModifiers())){
                    field.setAccessible(true);
                    try (PrintWriter pw = new PrintWriter(file)) {
                        String gsonHuman = gson.toJson(field.getName());
                        pw.println(gsonHuman);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            } else continue;
        }

    }

    public static TestClass loadFromJSONFile(File file) {

        Gson gson = new Gson();
        TestClass human = null;
        try {
            human = gson.fromJson(new FileReader(file), TestClass.class);
        }
        catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return human;
    }
}
