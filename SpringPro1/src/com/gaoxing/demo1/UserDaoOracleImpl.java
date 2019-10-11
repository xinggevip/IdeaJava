package com.gaoxing.demo1;

import lombok.Setter;

@Setter
public class UserDaoOracleImpl implements UserDao {
    public String name;
    @Override
    public void save() {
        System.out.println("Oracle-save");
    }

    @Override
    public void delete() {
        System.out.println("Oracle-delete");
    }
}
