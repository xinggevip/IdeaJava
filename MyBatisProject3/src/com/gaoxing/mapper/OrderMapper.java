package com.gaoxing.mapper;

import com.gaoxing.domain.Order;

import java.util.List;

public interface OrderMapper {
    /* 查询所有订单 */
    public List<Order> getAllOrder();
}
