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

    @Test
    public void test2(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();

        Linkman linkman = currentSession.get(Linkman.class, 1L);

        transaction.commit();

        System.out.println(linkman.getLink_name());
        System.out.println(linkman.getCustomer().getCust_name());
    }

    // 级联保存
    @Test
    public void test3(){
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

        // 保存
        currentSession.save(customer1);
        currentSession.save(customer2);
        currentSession.save(customer3);

        transaction.commit();
    }

    // 级联删除
    @Test
    public void test4(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        /**
         * 默认删除
         * 打断两个表之间的关系 link_cust_id = null
         * 再去删除记录，并没有级联删除
         *
         * 想要级联删除，必须配置
         */
        Customer customer = currentSession.get(Customer.class, 3L);
        currentSession.delete(customer);

        transaction.commit();
    }
}
