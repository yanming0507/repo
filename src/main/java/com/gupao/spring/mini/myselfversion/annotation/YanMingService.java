package com.gupao.spring.mini.myselfversion.annotation;

import java.lang.annotation.*;

/**
 * Created by Yan on 2019/4/11.
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface YanMingService {
    String value() default "";
}
