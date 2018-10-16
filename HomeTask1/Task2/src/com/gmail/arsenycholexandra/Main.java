package com.gmail.arsenycholexandra;

/*
2. Написать класс TextContainer, который содержит в себе строку. С помощью механизма аннотаций указать
1) в какой файл должен сохраниться текст 2) метод, который выполнит сохранение. Написать класс Savers,
который сохранит поле класса TextContainer в указанный файл.
@SaveTo(path=“c:\\file.txt”)
class Container {
String text = “…”;
@Savers
public void save(..) {…}
}
*/

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {




    public static void main(String[] args) {
        Savers tct = new Savers();
        Class<?> cls = tct.getClass();
        Method[] methods = cls.getDeclaredMethods();

        if( ! cls.isAnnotationPresent(SaverAnnotation.class)){
            System.out.println("No Annotation");
            return;
        }

        SaverAnnotation svr = cls.getAnnotation(SaverAnnotation.class);
        String path = svr.path();

        for (Method method : methods){
            if (method.isAnnotationPresent(Save.class)){
                try {
                    method.invoke(tct, path);
                    break;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }





}
