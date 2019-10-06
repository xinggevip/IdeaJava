package com.gaoxing.test;

import com.gaoxing.domain.Customer;
import com.gaoxing.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateTest2 {
    @Test
    public void test1(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();

        Customer customer = currentSession.get(Customer.class, 34L);
        System.out.println(customer);

        transaction.commit();
        // currentSession.close(); 不需要手动close，会自动close
    }
}
