package com.gaoxing.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User u = (User)applicationContext.getBean("user");
        System.out.println(u); // User{name='Tom', dog=Dog{name='大黄'}}
        ((ClassPathXmlApplicationContext) applicationContext).close(); // destroy----销毁时调用(单例模式开发)
    }

}
