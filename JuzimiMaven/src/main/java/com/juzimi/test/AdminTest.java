package com.juzimi.test;

import com.github.pagehelper.PageInfo;
import com.juzimi.domain.*;
import com.juzimi.mapper.AdminMapper;
import com.juzimi.service.AdminSerive;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void adminGetSentence(){
        // 管理员获取句子列表测试
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminSerive adminSerive = springApp.getBean(AdminSerive.class);

        PageInfo<Sentence> pageInfo = adminSerive.getSentenceResult(1, 10);

        for (Sentence sentence : pageInfo.getList()) {
            System.out.println(sentence);
        }

        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("每页显示记录数:"+pageInfo.getPageSize());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总记录数:"+pageInfo.getTotal());
        System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
        System.out.println("是否有下一页:"+pageInfo.isHasNextPage());
        System.out.println("导航页码:"+ Arrays.toString(pageInfo.getNavigatepageNums()));

    }

    // 获取统计信息
    @Test
    public void getCountResultTest(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminSerive adminSerive = springApp.getBean(AdminSerive.class);
        CountResult countResult = adminSerive.getCountResult();
        System.out.println(countResult);
    }

    // 统计新增数据
    @Test
    public void getCountListResultTest(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminSerive adminSerive = springApp.getBean(AdminSerive.class);
        List<CountListResult> countListResult = adminSerive.getCountListResult(7);
        for (CountListResult result : countListResult) {
            System.out.println(result);
        }
    }

    // 搜索用户
    @Test
    public void searchUsersTest(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminSerive adminSerive = springApp.getBean(AdminSerive.class);
        PageInfo<Users> pageInfo = adminSerive.searchUsersByIdOrName("x", 1, 10);
        for (Users user : pageInfo.getList()) {
            System.out.println(user);
        }

        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("每页显示记录数:"+pageInfo.getPageSize());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总记录数:"+pageInfo.getTotal());
        System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
        System.out.println("是否有下一页:"+pageInfo.isHasNextPage());
        System.out.println("导航页码:"+ Arrays.toString(pageInfo.getNavigatepageNums()));
    }

    @Test
    public  void selectUsersByIdOrNameTest(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminMapper adminSerive = springApp.getBean(AdminMapper.class);

        List<Users> usesList = adminSerive.selectUsersByIdOrName("高");

        for (Users users : usesList) {
            System.out.println(users);
        }

    }

    @Test
    public void searchAlbumByNameOrDetailsTest(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminSerive adminSerive = springApp.getBean(AdminSerive.class);
        PageInfo<Album> pageInfo = adminSerive.searchAlbumByNameOrDetails("家", 1, 10);
        for (Album album : pageInfo.getList()) {
            System.out.println(album);
        }
    }

    // 搜索句子测试
    @Test
    public void searchSentenceByTxtOrAuthorNameTest(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminSerive adminSerive = springApp.getBean(AdminSerive.class);
        PageInfo<Sentence> pageInfo = adminSerive.searchSentenceByTxtOrAuthorName("你", 1, 10);
        for (Sentence sentence : pageInfo.getList()) {
            System.out.println(sentence);
        }
    }
}
