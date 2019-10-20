package com.gaoxing.web.controller;

import com.gaoxing.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("testUpdata/{id}")
    public String testUpdata(@PathVariable Integer id, Model model){
        System.out.println(id);
        User user = new User();
        user.setUsername("gaoxing");
        user.setAge("18");
        model.addAttribute("user",user);
        // model.addAttribute("command",user); key为command   form标签可以不写modelAttribute参数  默认为command
        return "/result.jsp"; // rest参数一定要带上斜杠
    }
}
