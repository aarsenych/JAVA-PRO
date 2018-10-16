package com.gmail.arsenycholexandra.arsenycholexandra;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface MyAnnotation {
    int a();

    int b();

}
