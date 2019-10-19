package com.gaoxing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController3 {
    /**
     * @RequestMapping之value属性
     * 多个请求映射到一个方法
     */
    @RequestMapping(value = {"testrequestmapping1","testrequestmapping2"})
    public String testrequest(){
        System.out.println("来到了testrequestmapping------------");
        return "/second.jsp";
    }
}
