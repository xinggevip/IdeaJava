package com.gaoxing.test;

import com.gaoxing.mapper.CustomerMapper;
import com.gaoxing.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void getAccountCustomer(){
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Integer accountCustomer = mapper.getAccountCustomer();
        System.out.println(accountCustomer);
        sqlSession.close();

    }
}
