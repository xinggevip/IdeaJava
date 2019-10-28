package com.gaoxing.service;

import com.gaoxing.domain.Customer;
import com.gaoxing.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Transactional 注解事务 自从提交sql代码
 */

@Service("CustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void saveCustomer(Customer customer) {
        System.out.println("来到了业务层-保存---" + customer);
        customerMapper.insertCustomer(customer);
    }
}
