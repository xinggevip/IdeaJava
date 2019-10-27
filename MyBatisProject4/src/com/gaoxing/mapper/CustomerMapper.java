package com.gaoxing.mapper;

import com.gaoxing.domain.Customer;
import com.gaoxing.domain.QueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    /* 根据客户的名称和职业查询客户 */
    public List<Customer> getCustomer (@Param("cust_name") String cust_name, @Param("cust_profession") String cust_profession);

    /* 更新客户 */
    public void updateCustomer(Customer customer);

    /* 根据指定多个id查客户 */
    /*public List<Customer> getCustomers (Integer[] arr);*/
    /*public List<Customer> getCustomers (List<Integer> arr);*/
    public List<Customer> getCustomers (QueryVo queryVo);

}
