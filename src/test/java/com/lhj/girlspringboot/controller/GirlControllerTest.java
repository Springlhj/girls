package com.lhj.girlspringboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;
/**
 * 对Api测试 (在项目打包的时候会对单元测试用例进行编译)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//区别于对service进行测试
@AutoConfigureMockMvc
public class GirlControllerTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void findAllGirl() throws Exception{
        //如果是get就写get,post对应修改为post
        mvc.perform(MockMvcRequestBuilders.get("/girl/findAllGirl"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //对期望返回的结果,它的内容是某一个值 MockMvcResultMatchers.content() 可以获取到它的内容
        .andExpect(MockMvcResultMatchers.content().string("abc"));
    }
}