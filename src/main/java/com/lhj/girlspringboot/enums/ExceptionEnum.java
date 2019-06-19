package com.lhj.girlspringboot.enums;

/**
 * 采用枚举的方式对不同的异常错误码和错误信息进行统一处理
 * 枚举当中一般不用给set方法,给get方法就好了,因为枚举的使用都是直接用它的构造方法来创建,不会再重新set了
 */
public enum ExceptionEnum {
    /**
     * 把所有的错误状态码,包括0,全部写到枚举中,这样子维护起来就比较方便了,也不用担心写重复
     */
    SUCCESS(0,"成功"),
    UNKONW_ERROR(-1,"未知错误"),
    PRIMARY_SCHOOL(100,"你可能还在上小学"),
    MIDDLE_SCHOOL(101,"你可能在上初中"),;
    private Integer code;
    private String message;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
