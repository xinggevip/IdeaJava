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
        System.out.println(student); // Student{name='jeak', age=18, dog=Dog{name='wccc', age=180, color='blue'}, dogName='wccc'}
    }
}
