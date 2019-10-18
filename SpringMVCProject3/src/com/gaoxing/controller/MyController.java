package com.gaoxing.controller;

import com.gaoxing.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class MyController {
    // 使用原声request对象接收参数
    @RequestMapping("/first")
    public String myform(HttpServletRequest request){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        System.out.println(id);
        System.out.println(name);
        return "/second.jsp";
    }

    // 简单类型参数RequestParam接收参数
    @RequestMapping("/second")
    public String myform2(@RequestParam(value = "id",required = false,defaultValue = "100") Integer key, String name){
        //  required = false 设置可以不传值，默认为true，defaultValue = "100"设置默认值，如果没有传值，则使用默认值
        System.out.println(key); // 起别名接收
        System.out.println(name); // 不起别名接收
        return "/second.jsp";
    }

    // JavaBean接收参数
    @RequestMapping("/myform")
    public String myform3(User user){ // 自动把参数封装成了对象
        System.out.println(user);
        return "/second.jsp";
    }

    // 数组接收参数
    @RequestMapping("/myform2")
    public String myform3(String user_hobby[]){
        System.out.println(Arrays.toString(user_hobby));
        return "/second.jsp";
    }

    // javabean接收参数含数组
    @RequestMapping("/myform4")
    public String myform4(User user){
        System.out.println(user);
        return "/second.jsp";
    }
}
