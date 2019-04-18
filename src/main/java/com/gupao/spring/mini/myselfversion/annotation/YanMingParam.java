package com.gupao.spring.mini.myselfversion.annotation;

import java.lang.annotation.*;

/**
 * Created by Yan on 2019/4/11.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface YanMingParam {
    String value() default "";
}
