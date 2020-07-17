package com.gaoxing.demo1;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
    public void save(){
        System.out.println("UserDao--save");
    }
    public void delete(){
        System.out.println("UserDao--delete");
    }
}
