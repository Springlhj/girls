package com.lhj.girlspringboot.entity;

/**
 * @program: girl-springboot
 * @description: http请求返回的最外层对象
 * @author: lhj
 * @create: 2019-04-01 16:15
 **/
public class ResponseData<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msssage;
    /**
     * 具体的内容
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsssage() {
        return msssage;
    }

    public void setMsssage(String msssage) {
        this.msssage = msssage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
