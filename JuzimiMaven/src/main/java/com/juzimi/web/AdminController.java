package com.juzimi.web;

import com.juzimi.domain.Admin;
import com.juzimi.service.AdminSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminSerive adminSerive;

    @RequestMapping("/adminlogin")
    @ResponseBody
    public Admin login(@RequestBody Admin admin){
        Admin login = adminSerive.login(admin);
        return login;
    }

}
