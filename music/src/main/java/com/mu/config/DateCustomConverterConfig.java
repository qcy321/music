package com.mu.config;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mu.util.MyTimeUtil;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 以下加入spring容器的bean均为对前端传过来的时间进行发序列化，即long转对象，及格式化时间转时间对象。
 */
@Configuration
public class DateCustomConverterConfig {

    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * 反序列化，将long转化成LocalDateTime
     * 反序列化，将yyyy-MM-dd HH:mm:ss格式的时间转化成LocalDateTime
     * 接受时间戳，将其转化为LocalDateTime对象
     */
    @Bean
    public Converter<String, LocalDateTime> localDateTimeConverter() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                try {
                    long l = Long.parseLong(source);
                    return LocalDateTimeUtil.of(l, ZoneId.systemDefault());
                } catch (NumberFormatException e) {
                    return LocalDateTime.parse(source, dateTimeFormatter);
                }
            }
        };
    }


    /**
     * 反序列化，将long转化成LocalDate
     * 接受时间戳，将其转化为LocalDate对象
     */

    @Bean
    public Converter<String, LocalDate> localDateConverter() {
        return new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(String source) {
                try {
                    long l = Long.parseLong(source);
                    return LocalDateTimeUtil.of(l).toLocalDate();
                } catch (NumberFormatException e) {
                    return LocalDateTime.parse(source, dateTimeFormatter).toLocalDate();
                }
            }
        };
    }

    /**
     * 反序列化，将long转化成LocalTime
     * 接受时间戳，将其转化为LocalTime对象
     */

    @Bean
    public Converter<String, LocalTime> localTimeConverter() {
        return new Converter<String, LocalTime>() {
            @Override
            public LocalTime convert(String source) {
                try {
                    long l = Long.parseLong(source);
                    return LocalDateTimeUtil.of(l).toLocalTime();
                } catch (NumberFormatException e) {
                    return LocalDateTime.parse(source, dateTimeFormatter).toLocalTime();
                }
            }
        };
    }

    /**
     * 反序列化，将long转化成LocalTime
     * 接受时间戳，将其转化为LocalTime对象
     */

    @Bean
    public Converter<String, Date> DateConverter() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                try {
                    long l = Long.parseLong(source);
                    return new Date(l);
                } catch (NumberFormatException e) {
                    return new Date(MyTimeUtil.getDateTimeLong(LocalDateTime.parse(source, dateTimeFormatter)));
                }
            }
        };
    }


    /**
     * description:适配自定义序列化和反序列化策略
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> {
            builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer());//添加策略，在遇到该类型是，执行下列序列化器
            builder.serializerByType(LocalDate.class, new LocalDateSerializer());
            builder.serializerByType(LocalTime.class, new LocalTimeSerializer());
        };
    }

    /**
     * 将LocalDateTime序列化为yyyy-MM-dd HH:mm:ss格式的时间
     */
    public static class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
        @Override
        public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers)
                throws IOException {
            if (value != null) {
                gen.writeNumber(value.format(dateTimeFormatter));
            }
        }
    }

    /**
     * 将LocalDate序列化为yyyy-MM-dd格式的时间
     */
    public static class LocalDateSerializer extends JsonSerializer<LocalDate> {
        @Override
        public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers)
                throws IOException {
            if (value != null) {
                gen.writeNumber(value.format(dateFormatter));
            }
        }
    }

    /**
     * 将LocalTime序列化为HH:mm:ss格式的时间
     */
    public static class LocalTimeSerializer extends JsonSerializer<LocalTime> {
        @Override
        public void serialize(LocalTime value, JsonGenerator gen, SerializerProvider serializers)
                throws IOException {
            if (value != null) {
                gen.writeNumber(value.format(timeFormatter));
            }
        }
    }

    /**
     * description:序列化
     * LocalDateTime序列化为毫秒级时间戳
     */
    /*public static class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
        @Override
        public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers)
                throws IOException {
            if (value != null) {
                long timestamp = MyTimeUtil.getDateTimeLong(value);
                gen.writeNumber(timestamp);
            }
        }
    }*/

    /**
     * description:反序列化
     * 毫秒级时间戳序列化为LocalDateTime
     */
    /*public static class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
        @Override
        public LocalDateTime deserialize(JsonParser p, DeserializationContext deserializationContext)
                throws IOException {
            long timestamp = p.getValueAsLong();
            if (timestamp > 0) {
                return LocalDateTimeUtil.of(timestamp, ZoneOffset.of("+8"));
            } else {
                return null;
            }
        }
    }*/

}
