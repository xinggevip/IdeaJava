package com.gaoxing.demo1;

public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("Mysql-save");
    }

    @Override
    public void delete() {
        System.out.println("Mysql-delete");
    }
}
