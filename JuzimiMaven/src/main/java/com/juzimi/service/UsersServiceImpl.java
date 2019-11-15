package com.juzimi.service;

import com.juzimi.domain.Result;
import com.juzimi.domain.Users;
import com.juzimi.mapper.AdminMapper;
import com.juzimi.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Users login(Users user) {
        // 如果管理员开启了审核，直接返回用户信息，如果没有开启审核则把用户的激活状态设置已激活
        if (adminMapper.selectByPrimaryKey("admin").getIsOpenActive() == 1){
            Users loginUser = usersMapper.selectByIdBypassword(user);
            return loginUser;
        }else {
            Users loginUser = usersMapper.selectByIdBypassword(user);
            loginUser.setIsActive(1);
            return loginUser;
        }
    }

    @Override
    public String register(Users user) {
        System.out.println("serive--register---" + user);
        // 设置默认激活状态
        user.setIsActive(0);
        // 设置默认头像地址
        user.setUserPicture("/headpicture/defaultpicture.png");
        // 设置注册日期
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        user.setCreateDate(Timestamp.valueOf(nowTime));
        // 设置默认签名
        user.setUserSlogan("又是元气满满的一天");
        // 设置默认性别
        user.setUserSex("男");
        try {
            int insert = usersMapper.insert(user);
            System.out.println("serive----register-----" + insert);

            if (insert > 0){
                return "success";
            }
        }catch (Exception e){
            return "fail";
        }

        return "fail";
    }

    @Override
    public Users getProFile(String userId) {
        try {
            Users users = usersMapper.selectByPrimaryKey(userId);
            users.setUserPassword("NaThingWidthPassWord");
            return users;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Result updataUser(Users user) {
        try {
            int i = usersMapper.updateByPrimaryKey(user);
            if (i > 0){
                return new Result(true,"更新成功");
            }else {
                return new Result(false,"更新失败");
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new Result(false,"更新失败");
        }
    }


}
