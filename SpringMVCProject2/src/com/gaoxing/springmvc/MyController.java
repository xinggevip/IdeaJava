package com.gaoxing.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    // 匹配请求可以省略.action
    @RequestMapping("/first")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView();

        // 请求过来后，跳转到另一个界面，往另一个界面传一些数据
        modelAndView.addObject("name","gaoxing");

         modelAndView.setViewName("redirect:/result.jsp");
         // modelAndView.setViewName("redirect:/second.action"); // // 发送请求不可以省略.action

        return modelAndView;
    }

    @RequestMapping("/second")
    public String show2(){
        return "redirect:/result.jsp";
    }
}
