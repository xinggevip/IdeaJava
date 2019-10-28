package com.gaoxing.service;

import com.gaoxing.domain.Customer;
import org.springframework.stereotype.Service;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
    @Override
    public void saveCustomer(Customer customer) {
        System.out.println("来到了业务层-保存---" + customer);
    }
}
