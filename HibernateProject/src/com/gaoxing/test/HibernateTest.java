package com.gaoxing.test;

import com.gaoxing.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {


    static void test1(){
        // 1.加载配置文件
        Configuration configure = new Configuration().configure();
        // 2.创建sessionFactory session工厂  类似于jdbc连接池
        SessionFactory sessionFactory = configure.buildSessionFactory();
        // 3.获取session对象 类似于获取连接对象
        Session session = sessionFactory.openSession();
        
        // 要操作谁就创建谁
        Customer customer = new Customer();
        customer.setCust_name("高星");
        customer.setCust_level("2");
        // 4.保存
        session.save(customer);
        // 5.释放资源
        session.close();
        sessionFactory.close();
    }

    public static void main(String[] args){
        test1();
    }
}
