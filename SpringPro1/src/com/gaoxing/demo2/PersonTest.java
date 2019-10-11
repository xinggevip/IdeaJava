package com.gaoxing.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {

    @Test
    public void tesst1(){
        // 加载核心配置文件 会帮你创建所有对象 自动调用init方法
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml"); // init
        Person p = (Person)applicationContext.getBean("person");
        System.out.println(p.name); // 小黑

        // 关闭工厂，所有对象都会销毁 自动调用destroy方法
        ((ClassPathXmlApplicationContext) applicationContext).close(); // destroy
    }
}
