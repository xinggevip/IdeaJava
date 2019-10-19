package com.gaoxing.web.controller;

import com.gaoxing.domain.Goods;
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

        Goods goods = new Goods();
        goods.setName("苹果");
        goods.setPrice("100");
        model.addAttribute(goods); // 属性的类型为key

        // 把request域转换成map
        System.out.println(model.asMap()); // {name=Model, goods=Goods{name='苹果', price='100'}}

        // 转发到指定网页
        return "result.jsp";
    }

}
