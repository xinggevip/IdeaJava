package com.juzimi.web;

import com.github.pagehelper.PageInfo;
import com.juzimi.domain.Admin;
import com.juzimi.domain.Result;
import com.juzimi.domain.SentenceRequestByAuto;
import com.juzimi.domain.Users;
import com.juzimi.service.AdminSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    // 获取所有用户和分页信息
    @RequestMapping("/admingetuserlist")
    @ResponseBody
    public PageInfo admingetuserlist(@RequestBody SentenceRequestByAuto request){
        PageInfo<Users> userListResult = adminSerive.getUserListResult(request.getPageNum(), request.getPageSize());
        return userListResult;
    }

    // 批量设置激活状态
    @RequestMapping("/adminsetusersyesact")
    @ResponseBody
    public Result adminsetusersyesact(@RequestBody List<Users> usersList){
        Result result = adminSerive.setYesActive(usersList);
        return result;
    }

    // 删除单个用户
    @RequestMapping("/admindeloneuser")
    @ResponseBody
    public Result admindeloneuser(@RequestBody Users user){
        Result result = adminSerive.delOneUser(user);
        return result;
    }

    // 批量删除
    @RequestMapping("/admindelsomeuser")
    @ResponseBody
    public Result admindelsomeuser(@RequestBody List<Users> usersList){
        Result result = adminSerive.delSomeUser(usersList);
        return result;
    }

}
