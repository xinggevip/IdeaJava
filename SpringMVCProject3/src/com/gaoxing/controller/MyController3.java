package com.gaoxing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     *  通配符
     *  ?代表匹配任意一个字符
     *  *代表匹配任意个任意字符
     */
    // @RequestMapping(value = "testTant?")
    @RequestMapping(value = "testTant*")
    public String testtant(){
        System.out.println("来到了testTant------------");
        return "/second.jsp";
    }

    @RequestMapping(value = "rest/{id}")
    public String testrest(@PathVariable Integer id){
        System.out.println("来到了rest------------");
        System.out.println(id); // 1
        return "/second.jsp";
    }


    /**
     * put请求错误处理：
     * 1.在目标jsp页面设置  isErrorPage="true"  return "/second.jsp";
     * 2.设置重定向 return "redirect:/localsecond/" + id;
     * 从tomcat8开始直接return jsp页面报405错误
     */
    @RequestMapping(value = "testRestForm/{id}",method = {RequestMethod.PUT})
    public String testRestForm(@PathVariable Integer id){
        System.out.println("来到了testRestForm------------");
        System.out.println(id);
        return "redirect:/localsecond/" + id;
    }

    @RequestMapping(value = "/localsecond/{id}")
    public String testRestForm1(@PathVariable Integer id){
        System.out.println("来到了localsecond------------");
        System.out.println(id);
        return "/second.jsp";
    }



}
