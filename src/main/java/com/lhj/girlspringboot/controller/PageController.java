package com.lhj.girlspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//跳转页面用Controller注解
@Controller
@RequestMapping(value = "index")
public class PageController {
    /**
     * 跳转指定html页面
     * @return
     */
    @RequestMapping(value = "/targetIndex",method = RequestMethod.GET)
    public String targetIndex(){
        return "/index";
    }
}
