package com.gaoxing.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class AttrbuteListenerTest implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent scae) {
        // 监听ServletContex对象添加属性
        System.out.println("Added-------" + scae.getName() + "==" + scae.getValue());
    }

    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("Removed-------" + scae.getName() + "==" + scae.getValue());
    }

    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("Replaced-------" + scae.getName() + "==" + scae.getValue());
    }
}
