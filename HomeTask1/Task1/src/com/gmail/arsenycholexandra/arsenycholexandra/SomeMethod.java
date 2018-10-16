package com.gmail.arsenycholexandra.arsenycholexandra;

public class SomeMethod {
    @MyAnnotation(a = 2, b = 5)
    public void test(int a, int b) {
        System.out.println(a * b);
    }
}
