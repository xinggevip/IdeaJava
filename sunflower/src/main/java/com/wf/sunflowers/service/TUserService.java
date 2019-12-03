package com.wf.sunflowers.service;

import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TUser;

public interface TUserService {
    // 注册
    public ResultInfo reg(TUser user);
    // 登录
    public TUser login(TUser user);
}
