package com.hejj.servise;

import com.hejj.App;
import com.hejj.bean.User;
import com.hejj.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {App.class})
public class ServiceTest {

    private Logger logger = LoggerFactory.getLogger(ServiceTest.class);

    @Resource
    private UserService userService;

    @Before
    public void test0(){
        logger.info("开始测试...");
    }

    @Test
    public void test01(){
        User user = userService.findByName("张三");
        System.out.println(user);
    }

    @After
    public void test1(){
        System.out.println("结束测试...");
    }
}
