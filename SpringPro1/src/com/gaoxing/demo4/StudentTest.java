package com.gaoxing.demo4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student)applicationContext.getBean("student");
        System.out.println(student);
        // Student{name='jeak', age=18, dog=Dog{name='wccc', age=180, color='blue'}, dogName='wccc', attr=[H, e, l, l, o], list=[今天, 天气, 不错], mySet=[这里是, set, 集合], myMap={key1=value1, key2=value2, key3=value3}}
    }
}
