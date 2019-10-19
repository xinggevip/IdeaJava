package com.gaoxing.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping(value = "testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        // 把数据存到request域中
        modelAndView.addObject("name","ModelAndView");
        // 转发到指定网页
        modelAndView.setViewName("result.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "testModel")
    public String testModel(Model model){
        // 把数据存到request域中
        model.addAttribute("name","Model");
        // 转发到指定网页
        return "result.jsp";
    }

}
