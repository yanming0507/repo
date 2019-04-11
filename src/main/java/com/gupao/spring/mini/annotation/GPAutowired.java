package com.gupao.spring.mini.annotation;

import java.lang.annotation.*;

/**
 * Created by Yan on 2019/4/10.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPAutowired {
    String value() default "";
}
