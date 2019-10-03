package com.gaoxing.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionListenerTest implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated--创建");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionDestoryed--销毁");
    }
}
