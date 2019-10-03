package com.gaoxing.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListnerTest implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent sre) {
        //System.out.println("request创建");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        //System.out.println("request销毁");
    }
}
