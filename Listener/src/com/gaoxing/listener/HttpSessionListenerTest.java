package com.gaoxing.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionListenerTest implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        // 获取当前监听的对象
        HttpSession session = se.getSession();
        System.out.println("监听session----" + session.getId());
        //HttpSession source = (HttpSession)se.getSource();
        System.out.println("sessionCreated--创建");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionDestoryed--销毁");
    }
}
