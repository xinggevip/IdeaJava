package com.gaoxing.test;

import com.gaoxing.domain.Customer;
import com.gaoxing.mapper.CustomerMapper;
import com.gaoxing.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;

public class MyTest {
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customerWidthId = mapper.getCustomerWidthId(1);
        System.out.println(customerWidthId); // Customer(cust_id=1, cust_name=高星, cust_profession=射手, cust_phone=15937067033, email=12341241@qq.com)
        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customerWidthBoth = mapper.getCustomerWidthBoth(1, "高星");
        System.out.println(customerWidthBoth);
        sqlSession.close();
    }

    @Test
    public void test3(){
        // 传map类型接收参数
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        /**
         * map里的key必须和customer.xml的参数名称一致
         */
        map.put("id",1);
        map.put("name","高星");
        Customer customerWidthBoth = mapper.getCustomerWidthBoth(map);
        System.out.println(customerWidthBoth); // Customer(cust_id=1, cust_name=高星, cust_profession=射手, cust_phone=15937067033, email=12341241@qq.com)
        sqlSession.close();

   }

   @Test
    public void test4(){
        // 传POJO类型接收参数
       SqlSession sqlSession = MybatisUtils.opensession();
       CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
       Customer customer = new Customer();
       /**
        * customer.xml里的参数必须和POJO类字段名称一样
        */
       /*customer.setCust_id(1);
       customer.setCust_name("高星");*/
       customer.setCustId(1);
       customer.setCustName("高星");
       Customer customerWidthBoth = mapper.getCustomerWidthBoth(customer);
       System.out.println(customerWidthBoth); // Customer(cust_id=1, cust_name=高星, cust_profession=射手, cust_phone=15937067033, email=12341241@qq.com)
   }
}
