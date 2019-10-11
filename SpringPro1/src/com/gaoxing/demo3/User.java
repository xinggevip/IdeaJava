package com.gaoxing.demo3;

public class User {
    /*public User(){
        super();
        System.out.println("默认构造方法");
    }*/
    public static User creatUser(){
        System.out.println("调用了creatUser---");
        return new User();
    }
}
