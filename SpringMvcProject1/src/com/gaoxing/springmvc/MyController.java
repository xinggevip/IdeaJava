package com.gaoxing.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping("/first.action")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView();

        // 请求过来后，跳转到另一个界面，往另一个界面传一些数据
        modelAndView.addObject("name","gaoxing");

        // modelAndView.setViewName("/result.jsp");
        modelAndView.setViewName("customer1");

        return modelAndView;
    }
}
