package com.lhj.girlspringboot.girlException;

import com.lhj.girlspringboot.enums.ExceptionEnum;

/**
 * @program: girl-springboot
 * @description: 自定义异常  (RuntimeException继承的是Exception,在Spring框架中,它只对你抛出的异常是RuntimeException才会进行事物回滚,
 * 如果抛出的是Exception的话,它是不会进行事物回滚的,这一点要特别注意)
 * @author: lhj
 * @create: 2019-04-01 17:40
 **/

public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
}
