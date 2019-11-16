package com.juzimi.web;

import com.juzimi.domain.IsRegister;
import com.juzimi.domain.Users;
import com.juzimi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
@CrossOrigin
public class UsersController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private IsRegister isRegister;

    @RequestMapping("/login")
    @ResponseBody
    public Users login(@RequestBody Users user){
        System.out.println(user);
        System.out.println("来到了web层");
//        调用service层
        Users loginuser = usersService.login(user);
        System.out.println("loginuser==" + loginuser);
        return loginuser;
//        return user;
    }

    @RequestMapping("/register")
    @ResponseBody
    public IsRegister register(@RequestBody Users user){
        System.out.println(user);
        System.out.println("来到了web层");
        /* 调用serive */
        String register = usersService.register(user);
        System.out.println(register);

        isRegister.setState(register);
        return isRegister;
    }

    @RequestMapping("/getprofilebyuserid")
    @ResponseBody
    public Users getprofilebyuserid(String userId){
        Users proFile = usersService.getProFile(userId);
        return proFile;
    }

}
