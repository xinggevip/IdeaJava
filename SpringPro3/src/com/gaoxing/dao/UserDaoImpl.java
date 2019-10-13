package com.gaoxing.dao;

public class UserDaoImpl implements UserDao{
    @Override
    public void delete() {
        System.out.println("从数据库中删除记录");
    }
}
