package com.lhj.girlspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlSpringbootApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public  void start(){
        try{
            int i = 1/0;
        }catch (Exception e){
            System.out.println("异常:"+e.toString());
        }
    }
}
