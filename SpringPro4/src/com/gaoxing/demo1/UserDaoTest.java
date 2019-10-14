package com.gaoxing.demo1;

import org.junit.Test;

public class UserDaoTest {
    @Test
    public void test1(){
        UserDao userDao = new UserDao();
        UserDaoCglibproxy userDaoCglibproxy = new UserDaoCglibproxy();
        UserDao cglibproxy = userDaoCglibproxy.createCglibproxy(userDao);
        cglibproxy.save();
        cglibproxy.updata();
        /**
         * 权限操作-----
         * 保存用户操作
         * 日志保存操作----
         * 更新用户操作
         */
    }
}
