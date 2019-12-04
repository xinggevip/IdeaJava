package com.wf.sunflowers.service;


import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TUser;
import com.wf.sunflowers.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
