package com.gmail.arsenycholexandra;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)


public @interface SaverAnnotation {
    String path();
}
