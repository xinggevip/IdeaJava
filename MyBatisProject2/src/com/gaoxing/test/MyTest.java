package com.gaoxing.test;

import com.gaoxing.domain.Customer;
import com.gaoxing.mapper.CustomerMapper;
import com.gaoxing.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
}
