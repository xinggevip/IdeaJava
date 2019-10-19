package com.gaoxing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MyController2 {
    @RequestMapping("convert")
    public ModelAndView testconvert(String age, Date date,String name){
        System.out.println(age); // 18
        System.out.println(date); // Sat Mar 09 00:00:00 GMT+08:00 2019
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date)); // 2019-03-09
        System.out.println(name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/second.jsp");
        return modelAndView;
    }
}
