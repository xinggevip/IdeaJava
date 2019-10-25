package com.gaoxing.test;

import com.gaoxing.dao.CustomerDao;
import com.gaoxing.dao.CustomerDaoImpl;
import com.gaoxing.domain.Customer;
import org.junit.Test;

import java.util.List;

public class MyTest2 {
    @Test
    public void test(){
        // 根据id查
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customerWidthId = customerDao.getCustomerWidthId(1);
        System.out.println(customerWidthId); // Customer(cust_id=1, cust_name=小小布, cust_profession=射手, cust_phone=15937067033, email=12341241@qq.com)

        // 查所有
        List<Customer> customers = customerDao.getAllCustomer();
        for (Customer customer : customers) {
            System.out.println(customer);
            /**
             * Customer(cust_id=1, cust_name=小小布, cust_profession=射手, cust_phone=15937067033, email=12341241@qq.com)
             * Customer(cust_id=2, cust_name=李白, cust_profession=刺客, cust_phone=18977665521, email=libai@163.com)
             * Customer(cust_id=3, cust_name=阿轲, cust_profession=刺客, cust_phone=18977665997, email=aike@qq.com)
             * ...
             */
        }

        // 更新
        Customer customerWidthId1 = customerDao.getCustomerWidthId(11);
        customerWidthId1.setCust_name("高星");
        customerDao.updataCustomer(customerWidthId1);

        // 删除
        customerDao.deleteCUstomer(12);

    }
}
