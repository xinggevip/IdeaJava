package com.gaoxing.web.controller;

import com.gaoxing.domain.Pet;
import com.gaoxing.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    @RequestMapping("testUpdata/{id}")
    public String testUpdata(@PathVariable Integer id, Model model){
        ArrayList<Pet> petList = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setId(1);
        pet1.setName("猫");
        Pet pet2 = new Pet();
        pet2.setId(2);
        pet2.setName("狗");
        Pet pet3 = new Pet();
        pet3.setId(3);
        pet3.setName("王八");
        petList.add(pet1);
        petList.add(pet2);
        petList.add(pet3);
        model.addAttribute("petList",petList);

        System.out.println(id);
        User user = new User();
        user.setUsername("gaoxing");
        user.setAge("18");
        user.setGender(0);
        String[] hobby = new String[]{"跑步","乒乓球"};
        user.setPet(pet2);
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
    public String updata2(@Valid User user, BindingResult bindingResult,Model model){
        System.out.println(user);
        ArrayList<Pet> petList = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setId(1);
        pet1.setName("猫");
        Pet pet2 = new Pet();
        pet2.setId(2);
        pet2.setName("狗");
        Pet pet3 = new Pet();
        pet3.setId(3);
        pet3.setName("王八");
        petList.add(pet1);
        petList.add(pet2);
        petList.add(pet3);
        model.addAttribute("petList",petList);

        ArrayList<String> allhobbys = new ArrayList<>();
        allhobbys.add("跑步");
        allhobbys.add("乒乓球");
        allhobbys.add("网球");
        allhobbys.add("羽毛球");
        model.addAttribute("allhobbys",allhobbys);

        if (bindingResult.getErrorCount() != 0){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError.getField() + ":" + fieldError.getDefaultMessage());
            }
            // 存在错误，返回原来的页面
            return "/result.jsp";
        }

        return "/result2.jsp";
    }

    @RequestMapping("getJson")
    @ResponseBody
    public User getJson(){
        User user = new User();
        user.setUsername("tom");
        user.setAge("20");
        return user;
    }

    @RequestMapping("getJson2")
    @ResponseBody
    public List<User> getJson2(){

        Pet pet1 = new Pet();
        pet1.setId(1);
        pet1.setName("猫");
        Pet pet2 = new Pet();
        pet2.setId(2);
        pet2.setName("狗");
        Pet pet3 = new Pet();
        pet3.setId(3);
        pet3.setName("王八");


        User user = new User();
        user.setUsername("tom");
        user.setAge("20");
        user.setGender(0);
        String[] hobby = new String[]{"跑步","乒乓球"};
        user.setHobby(hobby);
        user.setPet(pet1);

        User user2 = new User();
        user2.setUsername("jak");
        user2.setAge("18");
        user2.setGender(1);
        String[] hobby2 = new String[]{"跑步","乒乓球","游泳"};
        user2.setHobby(hobby2);
        user2.setPet(pet2);

        User user3 = new User();
        user3.setUsername("hani");
        user3.setAge("22");
        user3.setGender(0);
        String[] hobby3 = new String[]{"跑步","棒球","游泳"};
        user3.setHobby(hobby3);
        user3.setPet(pet3);

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }

    @RequestMapping("myForm")
    @ResponseBody
    public User myForm(@RequestBody User user){
        System.out.println(user);
        return user;
    }

    @RequestMapping("myform")
    public String myform(@RequestBody String body){
        System.out.println(body);
        return "result2.jsp";
    }
}
