package com.mu.annotation;

import java.lang.annotation.*;

/**
 * 在方法上加了这个表明该返回结果需要包装
 * 在类上，所有的controller都需要封装结果
 * 自定义包装注解，在controller的类名或者方法上使用，可以对处理结果进行统一封装处理
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
