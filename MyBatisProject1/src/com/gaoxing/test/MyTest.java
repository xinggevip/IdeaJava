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
    }
}
