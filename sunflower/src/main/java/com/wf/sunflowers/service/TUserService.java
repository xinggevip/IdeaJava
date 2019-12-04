package com.wf.sunflowers.service;

import com.github.pagehelper.PageInfo;
import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TUser;

public interface TUserService {
    // 注册
    public ResultInfo reg(TUser user);
    // 登录
    public TUser login(TUser user);
    // 更新资料
    public ResultInfo edit(TUser user);
    // 根据关键词获取所有用户
    public PageInfo<TUser> getAllUser(String key, Integer pageNum, Integer pageSize);
}
