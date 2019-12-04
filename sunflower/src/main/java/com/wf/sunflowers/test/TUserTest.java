package com.wf.sunflowers.test;

import com.github.pagehelper.PageInfo;
import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TUser;
import com.wf.sunflowers.service.TUserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class TUserTest {
    // 根据关键词获取所有用户
    @Test
    public void getAllUserTest(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        TUserService tUserService = springApp.getBean(TUserService.class);
        PageInfo<TUser> pageInfo = tUserService.getAllUser("王", 1, 10);
        for (TUser tUser : pageInfo.getList()) {
            System.out.println(tUser);
        }
        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("每页显示记录数:"+pageInfo.getPageSize());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总记录数:"+pageInfo.getTotal());
        System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
        System.out.println("是否有下一页:"+pageInfo.isHasNextPage());
        System.out.println("导航页码:"+ Arrays.toString(pageInfo.getNavigatepageNums()));
    }
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
