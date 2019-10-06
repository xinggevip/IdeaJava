package com.gaoxing.test;

import com.gaoxing.domain.Customer;
import com.gaoxing.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class HibernateTest {

    // 插入记录
    @Test
    public void test1(){
        Session session = HibernateUtils.openSession();

        // 要操作谁就创建谁
        Customer customer = new Customer();
        customer.setCust_name("高星");
        customer.setCust_level("2");
        // 4.保存
        session.save(customer);
        // 5.释放资源
        session.close();
        HibernateUtils.sessionFactory.close();
    }

    // 查询记录，根据id
    @Test
    public void test2(){
        // 获取连接对象
        Session session = HibernateUtils.openSession();
        // 查询一条纪录
        Customer customer = session.get(Customer.class, 34L);
        // 打印
        System.out.println(customer);
        // 释放资源
        session.close();
    }

    // 更新记录一
    @Test
    public void test3(){
        /**
         * 更新操作方法一
         * 创建对象更新，只更新设置的字段，没有设置的字段自动设置为null
         */

        // 获取连接对象
        Session session = HibernateUtils.openSession();
        // 更新操作必须开启事务
        Transaction transaction = session.beginTransaction();
        // 创建更新对象
        Customer customer = new Customer();
        customer.setCust_id(34L);
        customer.setCust_name("星哥无敌");
        // 更新
        session.update(customer);
        // 提交事务
        transaction.commit();
        // 释放资源
        session.close();
    }

    // 更新记录2
    @Test
    public void test4(){
        /**
         * 更新操作方法二
         * 先查询再更新，只更新设置的字段，效果理想
         */

        // 获取连接对象
        Session session = HibernateUtils.openSession();
        // 更新操作必须开启事务
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, 34L);
        customer.setCust_name("修改后的名字");
        customer.setCust_level("5");
        // 更新
        session.update(customer);
        // 提交事务
        transaction.commit();
        // 释放资源
        session.close();
    }

    // 删除记录一
    @Test
    public void test5(){
        // 获取连接对象
        Session session = HibernateUtils.openSession();
        // 开启事务
        Transaction transaction = session.beginTransaction();
        // 创建对象
        Customer customer = new Customer();
        // 设置对象id属性
        customer.setCust_id(35L);
        // 根据对象id属性删除记录
        session.delete(customer);
        // 提交事务
        transaction.commit();
        // 关闭资源
        session.close();
    }

    // 删除记录二
    @Test
    public void test6(){
        // 获取连接对象
        Session session = HibernateUtils.openSession();
        // 开启事务
        Transaction transaction = session.beginTransaction();
        // 获取对象
        Customer customer = session.get(Customer.class, 36L);
        // 根据对象id属性删除记录
        session.delete(customer);
        // 提交事务
        transaction.commit();
        // 关闭资源
        session.close();
    }

    // savaOrUpdate
    @Test
    public void test7(){
        // 获取连接对象
        Session session = HibernateUtils.openSession();
        // 开启事务
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setCust_id(35L);
        customer.setCust_name("6688");
        customer.setCust_level("5");
        // 没有设置id 为保存操作 设置id为更新操作
        session.saveOrUpdate(customer);
        // 提交事务
        transaction.commit();
        // 关闭资源
        session.close();
    }

    // 获取所有记录
    @Test
    public void test8(){
        // 获取连接对象
        Session session = HibernateUtils.openSession();
        // 开启事务
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from com.gaoxing.domain.Customer");
        List<Customer> list = query.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }


        // 提交事务
        transaction.commit();
        // 关闭资源
        session.close();
    }

    //  持久化类对象划分
    @Test
    public void test9(){
        // 获取连接对象
        Session session = HibernateUtils.openSession();
        // 开启事务
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer(); // 瞬时态对象
        customer.setCust_id(35L);
        customer.setCust_name("6688");
        customer.setCust_level("5");
        session.saveOrUpdate(customer); // customer变成了持久化对象
        customer.setCust_name("持久化");

        // 提交事务
        transaction.commit();
        // 关闭资源
        session.close(); // 关闭session，放入session中关闭之前customer都是持久化态对象
        System.out.println(customer.getCust_name()); // customer为游离态对象
    }


}
