package com.mu.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.mu.annotation.AddUrlPrefix;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

public class UrlPreFixCustomConfig {

    /*@Autowired
    private StoragePathProperties properties;

    public static final String PREFIX_NAME = "AddUrlPrefix";

    @Bean
    public JsonSerializer<String> PrefixIsBlank() {
        return new JsonSerializer<String>() {
            @Override
            public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                System.out.println("空");
                jsonGenerator.writeString(properties.staticResourcePath + s);
            }
        };
    }


    @Bean
    public JsonSerializer<String> PrefixIsNotBlank() {
        return new JsonSerializer<String>() {
            @Override
            public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                System.out.println("不为空" + serializerProvider.getAttribute(PREFIX_NAME));
                jsonGenerator.writeString(serializerProvider.getAttribute(PREFIX_NAME) + s);
            }
        };
    }*/
}
