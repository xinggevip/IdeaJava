package com.gaoxing.mapper;

import com.gaoxing.domain.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    /* 根据客户的名称和职业查询客户 */
    public List<Customer> getCustomer (@Param("cust_name") String cust_name, @Param("cust_profession") String cust_profession);

}
