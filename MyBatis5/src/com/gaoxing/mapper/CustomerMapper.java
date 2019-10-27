package com.gaoxing.mapper;

import com.gaoxing.domain.Customer;

public interface CustomerMapper {
    /* 根据id查询客户 */
    public Customer getCustomer(Integer id);
    /* 插入客户 */
    public void insertCustomer(Customer customer);

}
