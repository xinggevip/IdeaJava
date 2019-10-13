package com.gaoxing.service;

import com.gaoxing.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userdao;

    @Override
    public void delete() {
        userdao.delete();
    }
}
