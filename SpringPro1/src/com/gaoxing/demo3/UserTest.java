package com.gaoxing.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        // 默认无参构造器实例化
        // User u = (User)applicationContext.getBean("user"); //  默认构造方法
        // 静态工厂实例化
        // User u = (User)applicationContext.getBean("user"); // 调用了creatUser---
        // 实例化工厂实例化
        User u = (User)applicationContext.getBean("user2"); // 调用了creatUser---
        System.out.println(u);
    }
}
