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

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        Customer customer = customerMapper.getCustomer(2);
        System.out.println(customer);

        sqlSession.close(); // 这句如果注释掉会发送两条sql
        /* sqlSession关闭时，会把一级缓存放到二级缓存，所以第一个sqlSession关闭后，第二个sqlSession执行不会发送sql */

        SqlSession sqlSession2 = MybatisUtils.opensession();
        CustomerMapper customerMapper2 = sqlSession2.getMapper(CustomerMapper.class);

        Customer customer2 = customerMapper2.getCustomer(2);
        System.out.println(customer2);

        sqlSession2.close();
    }

}
