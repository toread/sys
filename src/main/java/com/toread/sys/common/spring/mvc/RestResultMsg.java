package com.toread.sys.common.spring.mvc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RestResultMsg {
    String success() default "操作成功";
    String fail() default "操作失败";
    String unknown() default "服务器繁忙,请稍后再试";
}
