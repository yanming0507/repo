package com.gupao.spring.mini.myselfversion.annotation;

import java.lang.annotation.*;

/**
 * Created by Yan on 2019/4/11.
 */
@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface YanMingAutowired {
    String value() default "";
}
