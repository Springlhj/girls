package com.lhj.girlspringboot.utils;

import com.lhj.girlspringboot.entity.ResponseData;

/**
 * @program: girl-springboot
 * @description: 异常工具类
 * @author: lhj
 * @create: 2019-04-01 16:36
 **/
public class ResponseDataUtil {
    public static ResponseData success(Object object){
        ResponseData responseData = new ResponseData();
        responseData.setCode(0);
        responseData.setMsssage("成功");
        responseData.setData(object);
        return responseData;
    }
    public static ResponseData success(){
        return success(null);
    }

    public static ResponseData error(Integer code,String message){
        ResponseData responseData = new ResponseData();
        responseData.setCode(code);
        responseData.setMsssage(message);
        return responseData;
    }
}
