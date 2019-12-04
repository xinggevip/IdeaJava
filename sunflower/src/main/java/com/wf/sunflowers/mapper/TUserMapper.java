package com.wf.sunflowers.mapper;

import com.wf.sunflowers.entity.TUser;
import java.util.List;

public interface TUserMapper {
    int deleteByPrimaryKey(Integer uid);

    // 注册
    int insert(TUser record);

    TUser selectByPrimaryKey(Integer uid);

    List<TUser> selectAll();

    // 更新
    int updateByPrimaryKey(TUser record);

    // 登录
    TUser selectByEmailAndPwd(TUser record);
}