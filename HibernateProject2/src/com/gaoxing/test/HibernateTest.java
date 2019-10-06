package com.gaoxing.test;

import com.gaoxing.domain.Customer;
import com.gaoxing.domain.Linkman;
import com.gaoxing.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateTest {

    @Test
    public void test1(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();

        Customer customer1 = new Customer();
        customer1.setCust_name("customer1");
        Customer customer2 = new Customer();
        customer2.setCust_name("customer2");
        Customer customer3 = new Customer();
        customer3.setCust_name("customer3");

        Linkman linkman1 = new Linkman();
        linkman1.setLink_name("linkman1");
        Linkman linkman2 = new Linkman();
        linkman2.setLink_name("linkman2");
        Linkman linkman3 = new Linkman();
        linkman3.setLink_name("linkman3");

        // 配置关系
        customer1.getLinkmens().add(linkman1);
        customer1.getLinkmens().add(linkman2);
        customer2.getLinkmens().add(linkman3);

        linkman1.setCustomer(customer1);
        linkman2.setCustomer(customer1);
        linkman3.setCustomer(customer2);

        // 保存
        currentSession.save(customer1);
        currentSession.save(customer2);
        currentSession.save(customer3);

        currentSession.save(linkman1);
        currentSession.save(linkman2);
        currentSession.save(linkman3);

        transaction.commit();
    }
}
