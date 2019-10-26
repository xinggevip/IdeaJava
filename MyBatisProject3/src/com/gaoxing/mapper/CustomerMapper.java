package com.gaoxing.mapper;

import com.gaoxing.damain.Customer;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {
    /* 查询总数 */
    public Integer getAccountCustomer();

    /* 根据id查询客户 返回对应类 */
    public Customer getCustomer(Integer id);

    /* 根据id查询客户 返回Map类型 */
    public Map<String,Object> getCustomerWidthId(Integer id);

    /* 获取所有客户 指定字段作为key */
    @MapKey("cust_id")
    public Map<Integer,Customer> getAllCustomer();

    /* 获取所有用户 返回list集合 */
    public List<Customer> getAllListCustomer();

}
