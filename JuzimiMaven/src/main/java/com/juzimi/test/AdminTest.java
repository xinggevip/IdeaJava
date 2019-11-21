package com.juzimi.test;

import com.github.pagehelper.PageInfo;
import com.juzimi.domain.Admin;
import com.juzimi.domain.Users;
import com.juzimi.service.AdminSerive;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class AdminTest {
    @Test
    public void adminLoginTest(){
        // 管理员登录测试
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminSerive adminSerive = springApp.getBean(AdminSerive.class);
        Admin admin = new Admin();
        admin.setAdminId("admin");
        admin.setAdminPassword("123");

        Admin login = adminSerive.login(admin);
        System.out.println(login);
    }
    @Test
    public void adminGetUserListTest(){
        // 管理员获取用户列表测试
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminSerive adminSerive = springApp.getBean(AdminSerive.class);

        PageInfo<Users> pageInfo = adminSerive.getUserListResult(1, 5);
        for (Users users : pageInfo.getList()) {
            System.out.println(users);
        }

        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("每页显示记录数:"+pageInfo.getPageSize());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总记录数:"+pageInfo.getTotal());
        System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
        System.out.println("是否有下一页:"+pageInfo.isHasNextPage());
        System.out.println("导航页码:"+ Arrays.toString(pageInfo.getNavigatepageNums()));


    }
}
