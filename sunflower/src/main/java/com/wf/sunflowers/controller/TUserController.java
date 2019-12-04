package com.wf.sunflowers.controller;

import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TUser;
import com.wf.sunflowers.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
@CrossOrigin
public class TUserController {
    @Autowired
    private TUserService tUserService;

    // 更新资料
    @RequestMapping("/edit")
    @ResponseBody
    public ResultInfo edit(@RequestBody TUser user){
        ResultInfo resultInfo = tUserService.edit(user);
        return resultInfo;
    }

    // 注册
    @RequestMapping("/reg")
    @ResponseBody
    public ResultInfo reg(@RequestBody TUser user){
        ResultInfo resultInfo = tUserService.reg(user);
        return resultInfo;
    }

    // 登录
    @RequestMapping("/login")
    @ResponseBody
    public TUser login(@RequestBody TUser user){
        TUser login = tUserService.login(user);
        return login;
    }

}
