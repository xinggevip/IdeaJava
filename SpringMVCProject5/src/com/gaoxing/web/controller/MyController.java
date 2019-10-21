package com.gaoxing.web.controller;

import com.gaoxing.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class MyController {
    @RequestMapping("testUpdata/{id}")
    public String testUpdata(@PathVariable Integer id, Model model){
        System.out.println(id);
        User user = new User();
        user.setUsername("gaoxing");
        user.setAge("18");
        user.setGender(0);
        String[] hobby = new String[]{"跑步","乒乓球"};
        user.setHobby(hobby);
        model.addAttribute("user",user);
        ArrayList<String> allhobbys = new ArrayList<>();
        allhobbys.add("跑步");
        allhobbys.add("乒乓球");
        allhobbys.add("网球");
        allhobbys.add("羽毛球");
        model.addAttribute("allhobbys",allhobbys);
        // model.addAttribute("command",user); key为command   form标签可以不写modelAttribute参数  默认为command
        return "/result.jsp"; // rest参数一定要带上斜杠
    }

    @RequestMapping("updata2")
    public String updata2(User user,Model model){
        System.out.println(user);
        model.addAttribute("user",user);
        ArrayList<String> allhobbys = new ArrayList<>();
        allhobbys.add("跑步");
        allhobbys.add("乒乓球");
        allhobbys.add("网球");
        allhobbys.add("羽毛球");
        model.addAttribute("allhobbys",allhobbys);
        return "result2.jsp";
    }
}
