package com.lhj.girlspringboot.handle;

import com.lhj.girlspringboot.entity.ResponseData;
import com.lhj.girlspringboot.girlException.GirlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lhj.girlspringboot.utils.ResponseDataUtil;

/**
 * @program: girl-springboot
 * @description: 异常捕获
 * @author: lhj
 * @create: 2019-04-01 17:34
 **/
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData handle(Exception e){
        //通过instanceof判断左边对象是否为instanceof 右边类的实例
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResponseDataUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            //因为错误被捕获了，所以后台没有报错，这里通过日志将其打印出来，以便排错
            logger.error("系统异常{}",e);
            return ResponseDataUtil.error(-1,"未知错误");
        }
    }

}
