package com.gaoxing.mapper;

import com.gaoxing.domain.Customer;
import org.apache.ibatis.annotations.Param;

public interface TestClass {
    public void insertCustomer(Customer customer);
    public void getCustomer(@Param("name") String name, @Param("id") Integer id);
}
