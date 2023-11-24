package com.mu.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mu.serializable.AddUrlPrefixSerializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 图片添加URL前缀
 * 对结果数据的序列化处理，在转换为json的时候，统一对单个字段进行处理
 * 在字段上添加该注解，可以对该字段进行响应的格式化处理
 *
 * @author author
 * @createDate 2020/12/18 8:54
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = AddUrlPrefixSerializer.class)//注解中引入自定义序列化器，该字段使用对应的序列化器
public @interface AddUrlPrefix {

    /**
     * 前缀
     *
     * @return
     */
    String value() default "";

}
