package com.lhj.girlspringboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 映射配置文件中的属性
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private String cupsize;
    private Integer age;

    public String getCupsize() {
        return cupsize;
    }

    public void setCupsize(String cupsize) {
        this.cupsize = cupsize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
