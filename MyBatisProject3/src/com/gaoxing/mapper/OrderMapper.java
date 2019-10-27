package com.gaoxing.mapper;

import com.gaoxing.domain.Order;

import java.util.List;

public interface OrderMapper {
    /* 查询所有订单 */
    public List<Order> getAllOrder();
    /* 根据id查询订单 */
    public Order getOrderWidthId(Integer id);
    /* 保存订单 */
    public void insertOrder(Order order);
    /* 根据cust_id查询订单 */
    public Order getOrder(Integer id);
}
