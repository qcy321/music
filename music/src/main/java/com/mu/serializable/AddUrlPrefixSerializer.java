package com.mu.serializable;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.mu.annotation.AddUrlPrefix;
import com.mu.config.StoragePathProperties;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * 自定义前缀序列化器
 * 给特定的字段添加前缀，例如图片的前缀，由于图片的存储路径有可能更改，存储在数据库一般为相对路径，而不是绝对路径。
 */
@Component
public class AddUrlPrefixSerializer extends JsonSerializer<String> implements ContextualSerializer {

    @Autowired
    private StoragePathProperties properties;

    private String prefix;

    //标识注解是否为空，如果为空则使用配置信息的路径，否则使用注解里的值
    public static final String PREFIX_NAME = "AddUrlPrefix";

    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (StringUtils.isBlank(prefix))
            jsonGenerator.writeString(properties.staticResourcePath + s);
        else
            jsonGenerator.writeString(prefix + s);
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        if (beanProperty != null) {
            String t = beanProperty.getAnnotation(AddUrlPrefix.class).value();
            if (StringUtils.isNotBlank(t))//判断字段是否包含该注解
                prefix = t;
            return this;
        }
        //如果beanProperty为null，就用value为null的方式序列化
        return serializerProvider.findNullValueSerializer(null);
    }
}
