package com.gaoxing.controller;

import com.gaoxing.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {
    @RequestMapping("/first")
    public String myform(HttpServletRequest request){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        System.out.println(id);
        System.out.println(name);
        return "/second.jsp";
    }

    @RequestMapping("/second")
    public String myform2(@RequestParam(value = "id",required = false,defaultValue = "100") Integer key, String name){
        //  required = false 设置可以不传值，默认为true，defaultValue = "100"设置默认值，如果没有传值，则使用默认值
        System.out.println(key); // 起别名接收
        System.out.println(name); // 不起别名接收
        return "/second.jsp";
    }

    @RequestMapping("/myform")
    public String myform3(User user){ // 自动把参数封装成了对象
        System.out.println(user);
        return "/second.jsp";
    }
}
