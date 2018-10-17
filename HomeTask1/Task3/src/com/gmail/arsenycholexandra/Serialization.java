package com.gmail.arsenycholexandra;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.*;
import java.lang.reflect.Field;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Serialization {

    private static List<String> getAnnotatedFields(TestClass human) throws IllegalAccessException {
        List<String> list = new ArrayList<>();
        Class<?> clas = human.getClass();
        Field[] fields = clas.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                field.setAccessible(true);
                String result = (String) field.get(human);
                list.add(result);
            }
        }
        return list;

    }

    public static void saveToJSON(TestClass human, File file) throws IllegalAccessException {
        List<String> list = getAnnotatedFields(human);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonList = gson.toJson(list);
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(gsonList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> loadFromJSONFile(File file) {
        List<String> list = new ArrayList<>();
        Gson gson = new Gson();
        try {
            Type type = new TypeToken<List>() {
            }.getType();
            list = gson.fromJson(new FileReader(file), type);
        } catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
