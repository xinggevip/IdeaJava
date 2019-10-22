package com.gaoxing.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("test1")
    public String test1(){
        return "result.jsp";
    }
}
