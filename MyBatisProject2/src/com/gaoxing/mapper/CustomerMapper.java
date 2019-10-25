package com.gaoxing.mapper;

import com.gaoxing.domain.Customer;
import org.apache.ibatis.annotations.Param;

/**
 * 参数传递
 *
 * 单个参数
 * 可以接受基本类型，对象类型，集合类型的值。
 * MyBatis可直接使用这个参数，不需要经过任何处理。
 * ***********************************
 * 多个参数
 * 任意多个参数，都会被MyBatis重新包装成一个Map传入。
 * Map的key是[arg1, arg0, param1, param2] ，值就是参数的值。
 * 自定义参数解决方案：
 * 参数前面加@Param("参数名")
 */

public interface CustomerMapper {
    public Customer getCustomerWidthId(Integer id);
    public Customer getCustomerWidthBoth(@Param("id") Integer id,@Param("name") String name);
}
