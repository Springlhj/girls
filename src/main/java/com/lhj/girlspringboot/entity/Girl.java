package com.lhj.girlspringboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * girl实体
 */
@Entity
public class Girl {
    @Id
    //主键自增
    @GeneratedValue
    private Integer id;
    private Integer age;
    private String cupSize;
    public Girl(){

    }

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

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", age=" + age +
                ", cupSize='" + cupSize + '\'' +
                '}';
    }
}
