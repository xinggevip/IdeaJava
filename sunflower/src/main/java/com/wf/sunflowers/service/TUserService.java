package com.wf.sunflowers.service;

import com.github.pagehelper.PageInfo;
import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TUser;

import java.util.List;

public interface TUserService {
    // 注册
    public ResultInfo reg(TUser user);
    // 登录
    public TUser login(TUser user);
    // 更新资料
    public ResultInfo edit(TUser user);
    // 根据关键词获取所有用户
    public PageInfo<TUser> getAllUser(String key, Integer pageNum, Integer pageSize);
    // 删除用户
    public ResultInfo delUser(TUser user);
    // 批量删除用户
    public ResultInfo delUsers(List<TUser> tUserList);
}
