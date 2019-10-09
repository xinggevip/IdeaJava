package com.gaoxing.myform;

import com.gaoxing.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class MyformAction4 extends ActionSupport {
    // 页面中提供表达式方式
    private User user;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String execute(){
        System.out.println(user);
        return null;
    }
}
