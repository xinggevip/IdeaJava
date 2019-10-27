package com.gaoxing.test;

import com.gaoxing.domain.Customer;
import com.gaoxing.mapper.CustomerMapper;
import com.gaoxing.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void getCustomer(){
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        List<Customer> customers = customerMapper.getCustomer("", "");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        Customer customer = new Customer();
        customer.setCust_id(2);
        customer.setCust_name("LiBai");
        customer.setCust_profession("肉");

        customerMapper.updateCustomer(customer);

        sqlSession.commit();
        sqlSession.close();
    }
}
