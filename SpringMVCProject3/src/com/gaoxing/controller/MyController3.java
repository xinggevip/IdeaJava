package com.gaoxing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    /**
     * 一个参数可以去掉大括号----
     * 用来设置映射的请求方式
     * 值是RequestMethod类型的数组
     * 如果没有写,则没有限制,post与get都可以请求到对应的方法
     * 如果指定了请求类型,则必须得是相应的请求才能访问到对应的方法
     */
    @RequestMapping(value = "testMethod",method = {RequestMethod.GET,RequestMethod.POST})
    public String testmethod(){
        System.out.println("来到了testMethod------------");
        return "/second.jsp";
    }

    @RequestMapping(value = "testParams",params = {"name=gaoxing","age!=1"})
    public String testparams(){
        System.out.println("来到了testParams------------");
        return "/second.jsp";
    }

    @RequestMapping(value = "testHeaders",headers = {"Host=localhost:8080","Referer=http://localhost:8080/requestmapping.jsp"})
    public String testheaders(){
        System.out.println("来到了testHeaders------------");
        return "/second.jsp";
    }

}
