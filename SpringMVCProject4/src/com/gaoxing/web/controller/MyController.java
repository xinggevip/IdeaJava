package com.gaoxing.web.controller;

import com.gaoxing.domain.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
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

    @RequestMapping("testSession2")
    /**
     * 使用@SessionAttribute来访问预先存在的全局会话属性
     * 如果没有 则会报错
     */
    public String testSession2(@SessionAttribute("name") String name){
        System.out.println(name);
        return "result3.jsp";
    }

    /**
     * 在RequestMapping映射方法前自动执行
     * 并提前传入model
     */
    @ModelAttribute
    public void testModelAttribute(Model model){
        System.out.println("ModelAttribute执行了");
        model.addAttribute("name","gaoxing");

        /* 名字和接收的别名一样会被覆盖 */
        Goods goods = new Goods();
        goods.setName("goodsName1");
        goods.setPrice("goodsPrice2");
        model.addAttribute("mygoods",goods);

        /* 名字不一样会存到model中 */
        Goods goods2 = new Goods();
        goods2.setName("goodsName2");
        goods2.setPrice("goodsPrice2");
        model.addAttribute("agoods",goods2);
    }

    @RequestMapping("testModelAttribute")
    // 会自动把模型存放到model中  即使不写model参数，也会存到request域中
    public String testModelAttribute(@ModelAttribute("mygoods") Goods goods, Model model){ // @ModelAttribute 默认存对象 名字为对象的小写类名，用此注解可以起别名
        System.out.println(goods); // Goods{name='SEO', price='999'}
        System.out.println(model.asMap()); // {{name=gaoxing, agoods=Goods{name='goodsName2', price='goodsPrice2'}, mygoods=Goods{name='SEO', price='999'}
        return "result3.jsp";
    }

}
