package com.bfchengnuo.firstspringboot.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 冰封承諾Andy on 2017/10/14.
 */
@Component
// 注入自定义的配置（对象）
@ConfigurationProperties(prefix = "girl")
// @PropertySource("classpath:application.yml")
public class Girl {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
