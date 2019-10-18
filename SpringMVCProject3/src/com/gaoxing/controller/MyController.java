package com.gaoxing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
