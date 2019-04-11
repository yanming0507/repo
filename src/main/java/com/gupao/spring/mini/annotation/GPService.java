package com.gupao.spring.mini.annotation;

import java.lang.annotation.*;

/**
 * Created by Yan on 2019/4/10.
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GPService {
    String value() default "";
}
