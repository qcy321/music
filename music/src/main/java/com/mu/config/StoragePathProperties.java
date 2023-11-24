package com.mu.config;

import lombok.Data;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "storage")
@Data
public class StoragePathProperties {
    //根路径
    private String rootPath;
    //用户头像路径
    private String userHead;

    private String defaultHead;

    public String staticResourcePath;

    //保存到数据库的公共路径
    public String commonHeadPath() {
        return userHead + defaultHead;
    }

}
