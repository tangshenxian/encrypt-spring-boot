package com.shenxian.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 自定义配置加密key
 * @author: shenxian
 * @date: 2022/1/19 9:57
 */
@ConfigurationProperties(prefix = "spring.encrypt")
public class EncryptProperties {

    private final static String DEFAULT_KEY = "www.shenxian.com";
    private String key = DEFAULT_KEY;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
