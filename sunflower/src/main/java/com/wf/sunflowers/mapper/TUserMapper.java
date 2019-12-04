package com.wf.sunflowers.mapper;

import com.wf.sunflowers.entity.TUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserMapper {
    // 删除用户
    int deleteByPrimaryKey(Integer uid);

    // 注册
    int insert(TUser record);

    TUser selectByPrimaryKey(Integer uid);

    List<TUser> selectAll();

    // 更新
    int updateByPrimaryKey(TUser record);

    // 登录
    TUser selectByEmailAndPwd(TUser record);

    // 根据关键词获取所有用户
    List<TUser> selectByKey(@Param("key") String key);
}