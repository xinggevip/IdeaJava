package com.gaoxing.test;

import com.gaoxing.domain.Customer;
import com.gaoxing.domain.CustomerExample;
import com.gaoxing.mapper.CustomerMapper;
import com.gaoxing.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyTest {
    @Test
    public void test1() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("./src/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    @Test
    public void test2(){
       /* SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        List<Customer> customers = customerMapper.selectAll();
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        sqlSession.close();*/
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        CustomerExample customerExample = new CustomerExample();

        CustomerExample.Criteria criteria1 = customerExample.createCriteria();
        criteria1.andEmailLike("%163%");

        CustomerExample.Criteria criteria2 = customerExample.createCriteria();
        criteria2.andCustProfessionEqualTo("刺客");

        customerExample.or(criteria2);

        /**
         * and条件可以链式操作，or要重新创建和其他操作
         */

        List<Customer> customers = customerMapper.selectByExample(customerExample);
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        sqlSession.close();
    }
}
