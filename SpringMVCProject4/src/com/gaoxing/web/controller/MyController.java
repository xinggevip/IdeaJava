package com.gaoxing.web.controller;

import com.gaoxing.domain.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
/* 把model中key为name存到session */
// @SessionAttributes("name")  or  @SessionAttributes(value = {"name1","name2})
/* 把model中key的类型为Strig的全部存到session */
@SessionAttributes(types = String.class)
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
        // System.out.println(model.asMap()); // {name=Model, goods=Goods{name='苹果', price='100'}}
        /*--------------------------------*/
        /**
         * model.addAllAttributes(hashMap);
         * 将map中的内容赋值到当前的model中
         * 如果当前model存在相同的内容，会被覆盖
         */
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name","tom");
        hashMap.put("hot","1000");
        model.addAllAttributes(hashMap);

        /**
         * model.addAllAttributes(arrayList);
         * 以集合中数据的类型做为key，
         * 将所提供的Collection中的所有属性复制到这个Map中,
         * 如果有同类型会存在覆盖现象
         */

        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("字符串1");
        arrayList.add("字符串2");
        model.addAllAttributes(arrayList);

        /**
         * model.containsAttribute("name");
         * 存在属性返回true，不存在返回false
         */
        System.out.println(model.containsAttribute("name")); // true

        /**
         * model.mergeAttributes(hashMap2);
         * 将attributes中的内容复制到当前的model中
         * 如果当前model存在相同内容，不会被覆盖
         */
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("name","姓名");
        model.mergeAttributes(hashMap2);

        System.out.println(model.asMap()); // {name=tom, goods=Goods{name='苹果', price='100'}, hot=1000, string=字符串2}

        // 转发到指定网页
        return "result.jsp";
    }

    @RequestMapping(value = "testMap")
    public String testMap(Map map){
        map.put("key1","value1");
        map.put("key2","value2");
        return "result.jsp";
    }

    @RequestMapping(value = "testSession")
    public String testSession(Model model){
        model.addAttribute("name","GaoXing");
        model.addAttribute("name2","xinggevip");
        return "result2.jsp";
    }

}
