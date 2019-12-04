package com.wf.sunflowers.test;

import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TUser;
import com.wf.sunflowers.service.TUserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TUserTest {
    // 更新测试
    @Test
    public void editTest(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        TUserService tUserService = springApp.getBean(TUserService.class);
        TUser tUser = new TUser();
        tUser.setUid(12);
        tUser.setUsername("王雨");
        tUser.setEmail("1511844263@qq.com");
        tUser.setPhone("15937067033");
        tUser.setPassword("123");
        tUser.setRole("pupil");
        ResultInfo resultInfo = tUserService.edit(tUser);
        System.out.println(resultInfo);
    }
    // 注册测试
    @Test
    public void regTest(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        TUserService tUserService = springApp.getBean(TUserService.class);
        TUser tUser = new TUser();
        tUser.setUsername("王雨");
        tUser.setEmail("1511844263@qq.com");
        tUser.setPhone("15937067033");
        tUser.setPassword("123");
        tUser.setRole("pupil");
        ResultInfo reg = tUserService.reg(tUser);
        System.out.println(reg);
    }
    // 登录测试
    @Test
    public void loginTest(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        TUserService tUserService = springApp.getBean(TUserService.class);
        TUser tUser = new TUser();
        tUser.setEmail("xiao@163.com");
        tUser.setPassword("123123");
        TUser login = tUserService.login(tUser);
        System.out.println(login);
    }
}
