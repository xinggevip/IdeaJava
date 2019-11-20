package com.juzimi.test;

import com.juzimi.domain.Admin;
import com.juzimi.service.AdminSerive;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
