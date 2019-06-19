package com.lhj.girlspringboot.controller.vo;

import com.lhj.girlspringboot.entity.Girl;

public class GirlQueryVo {
    private Integer id;
    private Integer age;
    private String cupSize;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Girl buildEntity(){
        Girl girl=new Girl();
        girl.setId(this.id);
        girl.setAge(this.age);
        girl.setCupSize(this.cupSize);
        return girl;
    }
}
