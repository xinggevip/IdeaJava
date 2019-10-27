package com.gaoxing.test;

import com.gaoxing.domain.Customer;
import com.gaoxing.mapper.CustomerMapper;
import com.gaoxing.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        Customer customer1 = customerMapper.getCustomer(2);
        System.out.println(customer1);

        /* 中间加入一个插入sql会让一级缓存失效 */
        Customer customer = new Customer();
        customer.setCust_name("小涨");
        customer.setCust_phone("15151515555");
        customer.setCust_profession("大堂经理");
        customerMapper.insertCustomer(customer);

        /* 清除缓存会让缓存失效 */
        sqlSession.clearCache();

        /* sqlSession没有close sql语句相同不会再次发送sql语句，会直接从一级缓存中取数据（缓存失效情况除外） */
        Customer customer2 = customerMapper.getCustomer(2);
        System.out.println(customer2);

        sqlSession.close();

    }

}
