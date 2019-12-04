package com.wf.sunflowers.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TUser;
import com.wf.sunflowers.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TUserServiceImpl implements TUserService {
    @Autowired
    private TUserMapper tUserMapper;
    // 注册
    @Override
    public ResultInfo reg(TUser user) {
        try {
            int i = tUserMapper.insert(user);
            if (i > 0){
                return new  ResultInfo(true,"注册成功");
            }else {
                return new  ResultInfo(false,"注册失败");
            }
        }catch (Exception e){
            return new  ResultInfo(false,"注册失败");
        }
    }

    // 登录
    @Override
    public TUser login(TUser user) {
        try {
            TUser tUser = tUserMapper.selectByEmailAndPwd(user);
            return tUser;
        }catch (Exception e){
            return null;
        }
    }

    // 更细资料
    @Override
    public ResultInfo edit(TUser user) {
        try {
            int i = tUserMapper.updateByPrimaryKey(user);
            if (i > 0){
                return new  ResultInfo(true,"更新成功");
            }else {
                return new  ResultInfo(false,"更新失败");
            }
        }catch (Exception e){
            return new  ResultInfo(false,"更新失败");
        }
    }

    // 根据关键词获取所有用户
    @Override
    public PageInfo<TUser> getAllUser(String key, Integer pageNum, Integer pageSize) {
        try {
            /* 配置分页查询 从第几页开始查，一页查多少条记录 */
            String orderBy = "uid  desc";//按照排序字段 倒序 排序
            Page<TUser> pageIn = PageHelper.startPage(pageNum,pageSize,orderBy);

            List<TUser> tUsers = tUserMapper.selectByKey(key);

            /* 信息更加详细 配置导航显示几条页码 */
            PageInfo<TUser> PageInfo = new PageInfo<>(tUsers, 3);

            return PageInfo;
        }catch (Exception e){
            return null;
        }

    }

    // 删除用户
    @Override
    public ResultInfo delUser(TUser user) {
        try {
            int i = tUserMapper.deleteByPrimaryKey(user.getUid());
            if (i > 0){
                return new  ResultInfo(true,"删除成功");
            }else {
                return new  ResultInfo(false,"删除失败");
            }
        }catch (Exception e){
            return new  ResultInfo(false,"删除失败");
        }
    }

    @Override
    public ResultInfo delUsers(List<TUser> tUserList) {
        try {
            for (TUser user : tUserList) {
                tUserMapper.deleteByPrimaryKey(user.getUid());
            }
            return new  ResultInfo(true,"操作成功");
        }catch (Exception e){
            return new  ResultInfo(false,"操作失败");
        }
    }
}
