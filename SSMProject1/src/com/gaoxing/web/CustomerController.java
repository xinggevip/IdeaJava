package com.gaoxing.web;

import com.gaoxing.domain.Customer;
import com.gaoxing.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    /* 注入业务层 */
    @Autowired
    private CustomerService customerService;

    @RequestMapping("addcustomer")
    public String addcustomer(Customer customer){
        /* 接收参数 */
        System.out.println("来到了web层-接收---" + customer);
        /* 把对象保存到数据库 调用业务层 */
        customerService.saveCustomer(customer);

        return "result";
    }
}
