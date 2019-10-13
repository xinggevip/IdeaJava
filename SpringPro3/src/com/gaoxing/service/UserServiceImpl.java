package com.gaoxing.service;

import com.gaoxing.dao.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao userdao;

    public void setUserdao(UserDao userdao) {
        this.userdao = userdao;
    }

    @Override
    public void delete() {
        userdao.delete();
    }
}
