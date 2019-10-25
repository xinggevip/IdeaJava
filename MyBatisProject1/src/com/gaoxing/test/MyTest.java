package com.gaoxing.test;

import com.gaoxing.domain.Customer;
import com.gaoxing.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class MyTest {

    @Test
    public void test() throws IOException {
        /*// 1.SqlSessionFactoryBuilder加载配置文件
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 2.读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMappingConfig.xml");

        // 3.获取session工厂
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

        // 4.获取会话  JDBC连接
        SqlSession sqlSession = sessionFactory.openSession();*/

        // 调用抽取的工具类
        SqlSession sqlSession = MybatisUtils.opensession();

        // 5.开始执行sql
        Object customerById = sqlSession.selectOne("queryCustomerById", 1);
        System.out.println(customerById); // Customer(cust_id=1, cust_name=鲁班, cust_profession=射手, cust_phone=13499887733, email=12341241@qq.com)

        // 6.关闭session
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.opensession();
        List<Customer> queryAllCustomer = sqlSession.selectList("queryAllCustomer");
        for (Customer customer : queryAllCustomer) {
            System.out.println(customer);
        }
        sqlSession.close();
    }

    @Test
    public void test3(){
        /**
         * 表示一个占位符号，通过#{}可以实现preparedStatement向占位符中设置值
         * 自动进行java类型和jdbc类型转换
         * #{}可以有效防止sql注入******************
         * #{}可以接收简单类型值或pojo属性值
         * 如果parameterType传输单个简单类型值,#{}括号中可以是value或其它名称
         * '#{cust_name}%' SELECT * FROM customer WHERE cust_name LIKE '?%'   ---  ？占位符自动转换参数，String会总动添加单引号
         *
         * *********************************************************************
         *
         * 不防sql注入************
         * 表示拼接sql串
         * 通过${}可以将parameterType 传入的内容拼接在sql中且不进行jdbc类型转换
         * ${}可以接收简单类型值或pojo属性值
         * 如果parameterType传输单个简单类型值，${}括号中只能是value
         * '${value}%' SELECT * FROM customer WHERE cust_name LIKE '李%'      ---   不自动转换参数，参数原封不动传过去
         */
        SqlSession sqlSession = MybatisUtils.opensession();
        List<Customer> customers = sqlSession.selectList("queryCustomerByName", "李%");
        sqlSession.close();
    }

    /* 添加客户 */
    @Test
    public void insert(){
        SqlSession sqlSession = MybatisUtils.opensession();

        Customer customer = new Customer();
        customer.setCust_name("星哥");
        customer.setCust_profession("java初级开发工程师");
        customer.setCust_phone("15937067033");
        customer.setEmail("1511844263@qq.com");

        sqlSession.insert("insertCustom",customer);

        // 当改动数据库当中的记录时，执行sql时要执行提交事务
        sqlSession.commit();
        System.out.println(customer); // Customer(cust_id=13, cust_name=星哥, cust_profession=java初级开发工程师, cust_phone=15937067033, email=1511844263@qq.com)
        // 关闭资源
        sqlSession.close();
    }
}
