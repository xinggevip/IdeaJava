package com.gaoxing.mapper;

import com.gaoxing.domain.Customer;

import java.util.List;

/**
 *  namespace必须和Mapper接口类路径一致
 *  id必须和Mapper接口方法名一致
 *  parameterType必须和接口方法参数类型一致
 *  resultType必须和接口方法返回值类型一致
 */
public interface CustomerMapper {
    // 根据id查客户
    public Customer queryCustomerById(Integer id);
    // 根据姓名模糊查询客户
    public Customer queryCustomerByName(String name);
    // 查所有客户
    public List<Customer> queryAllCustomer();
    // 添加客户
    public void insertCustom(Customer customer);
    // 更新客户
    public void updataCustomer(Customer customer);
    // 删除客户
    public void deleteCustomer(Customer customer);
}
