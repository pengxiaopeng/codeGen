package com.codegen.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION todo
 * @create 2018-05-31 11:39
 **/
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface FreemarkerComponent {
    String value() default "";
}
