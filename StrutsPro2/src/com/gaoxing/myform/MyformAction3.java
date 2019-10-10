package com.gaoxing.myform;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;
import java.util.List;


public class MyformAction3 extends ActionSupport {
    private String username;
    private Date age;
    private List hobby;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public void setHobby(List hobby) {
        this.hobby = hobby;
    }

    public String execute(){
        System.out.println(username);
        System.out.println(age);
        System.out.println(hobby);
        return null;
    }
}
