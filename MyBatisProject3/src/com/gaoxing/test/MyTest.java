package com.gaoxing.test;

import com.gaoxing.damain.Customer;
import com.gaoxing.mapper.CustomerMapper;
import com.gaoxing.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void getAccountCustomer(){
        /* 查总数 */
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Integer accountCustomer = mapper.getAccountCustomer();
        System.out.println(accountCustomer);
        sqlSession.close(); // 11

    }

    @Test
    public void getCustomer(){
        /* 查记录 返回对应类 */
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.getCustomer(1);
        System.out.println(customer); // Customer(cust_ids=1, cust_names=高星, cust_professions=射手, cust_phones=15937067033, email=12341241@qq.com)
        sqlSession.close();
    }

    @Test
    public void getCustomerWidthId(){
        /* 查记录 返回对应Map */
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Map<String, Object> customerWidthId = mapper.getCustomerWidthId(1);
        System.out.println(customerWidthId); // {cust_profession=射手, cust_name=高星, cust_id=1, cust_phone=15937067033, email=12341241@qq.com}
        sqlSession.close();
    }

    @Test
    public void getAllCustomer(){
        /* 查询所有客户 key为指定字段，value为对应类 */
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Map<Integer, Customer> allCustomer = mapper.getAllCustomer();
        System.out.println(allCustomer);
        // {1={cust_profession=射手, cust_name=高星, cust_id=1, cust_phone=15937067033, email=12341241@qq.com}, 2={cust_profession=刺客, cust_name=李白, cust_id=2, cust_phone=18977665521, email=libai@163.com}...}
        sqlSession.close();
    }

    @Test
    public void getAllListCustomer(){
        /* 查询所有客户 返回list 集合 */
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> allListCustomer = mapper.getAllListCustomer();
        System.out.println(allListCustomer);
        // [Customer(cust_id=1, cust_name=高星, cust_profession=射手, cust_phone=15937067033, email=12341241@qq.com), Customer(cust_id=2, cust_name=李白, cust_profession=刺客, cust_phone=18977665521, email=libai@163.com)...]
        for (Customer customer : allListCustomer) {
            System.out.println(customer);
            /**
             * Customer(cust_id=1, cust_name=高星, cust_profession=射手, cust_phone=15937067033, email=12341241@qq.com)
             * Customer(cust_id=2, cust_name=李白, cust_profession=刺客, cust_phone=18977665521, email=libai@163.com)
             * ...
             */
        }
        sqlSession.close();
    }
}
