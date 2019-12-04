package com.wf.sunflowers.controller;

import com.github.pagehelper.PageInfo;
import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TUser;
import com.wf.sunflowers.service.TUserService;
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
public class TUserController {
    @Autowired
    private TUserService tUserService;

    // 批量删除用户
    @RequestMapping("/delusers")
    @ResponseBody
    public ResultInfo delusers(@RequestBody List<TUser> tUserList){
        ResultInfo resultInfo = tUserService.delUsers(tUserList);
        return resultInfo;
    }

    // 删除用户
    @RequestMapping("/deluser")
    @ResponseBody
    public ResultInfo deluser(@RequestBody TUser user){
        ResultInfo resultInfo = tUserService.delUser(user);
        return resultInfo;
    }

    // 根据关键词获取所有用户
    @RequestMapping("/getalluserbykey")
    @ResponseBody
    public PageInfo<TUser> getalluserbykey(String key, Integer pageNum, Integer pageSize){
        PageInfo<TUser> pageInfo = tUserService.getAllUser(key, pageNum, pageSize);
        return pageInfo;
    }

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
