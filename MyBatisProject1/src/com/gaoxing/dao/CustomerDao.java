package com.gaoxing.dao;

import com.gaoxing.domain.Customer;

import java.util.List;

public interface CustomerDao {
    // 根据id获取记录
    public Customer getCustomerWidthId(Integer id);
    // 获取所有记录
    public List<Customer> getAllCustomer();
    // 添加记录
    public void addCustomer(Customer customer);
    // 更新记录
    public void updataCustomer(Customer customer);
    // 删除记录
    public void deleteCUstomer(Integer id);



}
