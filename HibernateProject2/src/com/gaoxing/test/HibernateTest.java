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

    // 更新
    @Test
    public void test5(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();

        Customer customer = currentSession.get(Customer.class, 2L);
        Linkman linkman = currentSession.get(Linkman.class, 1L);
        customer.getLinkmens().add(linkman);
        // 关联
        // 单项维护
        /*currentSession.save(customer);*/
        linkman.setCustomer(customer); // 两句效果一致
        // 双向维护  让一方放弃外键维护
        // inverse="true" true让一方放弃外键维护 false让一方不放弃外键维护 默认不放弃 适用于双向关联的情景，如果双向关联其中一方不放弃外键维护，就会造成更新两次
        /*currentSession.save(customer);*/
        /*linkman.setCustomer(customer);*/

        transaction.commit();
    }
}
