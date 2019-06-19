package com.lhj.girlspringboot.controller;

import com.lhj.girlspringboot.config.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;
    /**
     * 返回json格式
     * @param id 可传可不传 不传默认为0
     * @return
     */
    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0")String id){
//        return "编号是:"+id;
        //调用开发环境中的属性
        return "年龄是"+girlProperties.getAge();
    }
}
