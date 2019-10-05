package com.gaoxing.test;

import com.gaoxing.domain.Customer;
import com.gaoxing.utils.HibernateUtils;
import org.hibernate.Session;

public class HibernateTest {


    static void test1(){
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

    public static void main(String[] args){
        test1();
    }
}
