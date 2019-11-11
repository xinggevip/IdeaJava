package com.juzimi.service;

import com.juzimi.domain.Users;
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

    @Override
    public Users login(Users user) {
        System.out.println("来到了service----login");
        Users loginUser = usersMapper.selectByIdBypassword(user);
        System.out.println("service--loginUser" + loginUser);
        return loginUser;
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
}
