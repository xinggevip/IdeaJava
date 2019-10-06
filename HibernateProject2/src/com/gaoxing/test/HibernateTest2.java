package com.gaoxing.test;

import com.gaoxing.domain.Role;
import com.gaoxing.domain.User;
import com.gaoxing.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateTest2 {

    @Test
    public void test1(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();

        // 创建用户
        User user1 = new User();
        user1.setUser_name("高星");
        User user2 = new User();
        user2.setUser_name("星哥");

        // 创建角色
        Role role1 = new Role();
        role1.setRole_name("上帝");
        Role role2 = new Role();
        role2.setRole_name("程序员");
        Role role3 = new Role();
        role3.setRole_name("工程师");

        // 配置关系
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);
        user2.getRoles().add(role2);
        user2.getRoles().add(role3);

        /*role1.getUsers().add(user1);
        role2.getUsers().add(user1);
        role2.getUsers().add(user2);
        role3.getUsers().add(user2);*/

        // 保存
        currentSession.save(user1);
        currentSession.save(user2);
        currentSession.save(role1);
        currentSession.save(role2);
        currentSession.save(role3);

        transaction.commit();
    }
}
