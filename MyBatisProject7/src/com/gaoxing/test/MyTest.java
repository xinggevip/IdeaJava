package com.gaoxing.test;

import com.gaoxing.domain.Customer;
import com.gaoxing.mapper.CustomerMapper;
import com.gaoxing.util.MybatisUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        /* 配置分页查询 从第几页开始查，一页查多少条记录 */
        Page<Customer> pageIn = PageHelper.startPage(6,2);

        List<Customer> customers = customerMapper.selectAll();

        /* 信息更加详细 配置导航显示几条页码 */
        PageInfo<Customer> pageInfo = new PageInfo<>(customers, 4);

        for (Customer customer : customers) {
            System.out.println(customer);
        }

        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("每页显示记录数:"+pageInfo.getPageSize());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总记录数:"+pageInfo.getTotal());
        System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
        System.out.println("是否有下一页:"+pageInfo.isHasNextPage());
        System.out.println("导航页码:"+ Arrays.toString(pageInfo.getNavigatepageNums()));

        /**
         * Customer{custId=11, custName='高星', custProfession='java初级开发工程师', custPhone='15937067033', email='1511844263@qq.com'}
         * Customer{custId=17, custName='新客户001', custProfession='护士', custPhone='15937067033', email='null'}
         * 当前页:6
         * 每页显示记录数:2
         * 总页数:8
         *
         * 总记录数:15
         * 是否有上一页:true
         * 是否有下一页:true
         * 导航页码:[4, 5, 6, 7]
         */


        sqlSession.close();
    }
}
