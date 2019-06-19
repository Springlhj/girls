package com.lhj.girlspringboot;

import com.lhj.girlspringboot.entity.Girl;
import com.lhj.girlspringboot.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: girl-springboot
 * @description: 对girlService测试
 * @author: lhj
 * @create: 2019-04-01 18:58
 **/
//表示要在测试环境中跑了,底层使用的是junit工具
@RunWith(SpringRunner.class)
//表示将启动我们整个Spring的工程
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl one = girlService.findOne(2);
        //断言,设置预期值和实际值,如果值不匹配则测试不通过
        Assert.assertEquals(new Integer(13),one.getAge());
    }

}
