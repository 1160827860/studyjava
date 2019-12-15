package com.darksouls.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.TYPE})
@Documented
@Inherited
public @interface Table {
    String value();
}
