package com.gmail.arsenycholexandra.arsenycholexandra;

/*
1. Создать аннотацию, которая принимает параметры для метода. Написать код, который вызовет метод,
помеченный этой аннотацией, и передаст параметры аннотации в вызываемый метод.
@Test(a=2, b=5)
public void test(int a, int b) {…}
dfagehaatrha
*/

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {

        SomeMethod meth = new SomeMethod();
        Class<?> cls = meth.getClass();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation myanno = method.getAnnotation(MyAnnotation.class);
                int result = (int) method.invoke(meth, myanno.a(), myanno.b());
                System.out.println(result);
            }
        }
    }
}

