package com.gaoxing.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    public static final SessionFactory sessionFactory;
    static {
        // 1.加载配置文件
        Configuration configure = new Configuration().configure();
        // 2.创建sessionFactory session工厂  类似于jdbc连接池
        sessionFactory = configure.buildSessionFactory();
    }
    public static Session openSession(){
        // 3.获取session对象 类似于获取连接对象
        Session session = sessionFactory.openSession();
        return session;
    }
}
