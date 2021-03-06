package com.gaoxing.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerTest implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        // 获取当前监听的对象
        // ServletContext servletContext = sce.getServletContext();
        ServletContext servletContext = (ServletContext) sce.getSource();
        // 服务器启动就会调用
        System.out.println("服务器启动");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // 服务器关闭就会调用
        System.out.println("服务器关闭");
    }
}
