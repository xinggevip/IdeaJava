package com.gaoxing.test;

import com.gaoxing.domain.Customer;
import com.gaoxing.domain.QueryVo;
import com.gaoxing.mapper.CustomerMapper;
import com.gaoxing.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void getCustomer(){
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        List<Customer> customers = customerMapper.getCustomer("", "");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        Customer customer = new Customer();
        customer.setCust_id(2);
        customer.setCust_name("LiBai");
        customer.setCust_profession("肉");

        customerMapper.updateCustomer(customer);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        /*Integer[] arr = new Integer[]{2,3,4};
        List<Customer> customers = customerMapper.getCustomers(arr);*/

        /*ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        List<Customer> customers = customerMapper.getCustomers(arrayList);*/

        QueryVo queryVo = new QueryVo();
        queryVo.setArr(new Integer[]{2,3,4});
        List<Customer> customers = customerMapper.getCustomers(queryVo);

        for (Customer customer : customers) {
            System.out.println(customer);
        }

        sqlSession.close();
    }

    @Test
    public void getCustomerWidthId(){
        SqlSession sqlSession = MybatisUtils.opensession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        Customer customer = customerMapper.getCustomerWidthId(2);
        System.out.println(customer); // Customer(cust_id=3, cust_name=阿轲, cust_profession=刺客, cust_phone=18977665997, email=aike@qq.com)

        sqlSession.close();
    }
}
