package com.gaoxing.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void test(){
        // 加载配置文件
        ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");
        // 根据id获取对象
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        userDao.save();
        userDao.delete();
    }
}

