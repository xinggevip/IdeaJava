package com.juzimi.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.juzimi.domain.Album;
import com.juzimi.domain.Users;
import com.juzimi.service.AlbumService;
import com.juzimi.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class UserTest {

    @Test
    public void userServiceTest(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService us = springApp.getBean(UsersService.class);
        Users u = new Users();
        u.setUserId("ggg");
        u.setUserPassword("kkk");
        String register = us.register(u);
        System.out.println(register);
        System.out.println(us);
    }

    @Test
    public void test(){
        // 测试通过类型id获取专辑列表
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AlbumService albumService = springApp.getBean(AlbumService.class);
        List<Album> albumsByClassifyId = albumService.getAlbumsByClassifyId(5);
        System.out.println(albumsByClassifyId);

    }

    @Test
    public void test1(){
        // 测试分页查询
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AlbumService albumService = springApp.getBean(AlbumService.class);

        /* 配置分页查询 从第几页开始查，一页查多少条记录 */
        Page<Album> pageIn = PageHelper.startPage(1,2);

        List<Album> albumList = albumService.getAlbumsByClassifyId(1);

        /* 信息更加详细 配置导航显示几条页码 */
        PageInfo<Album> pageInfo = new PageInfo<>(albumList, 3);

        for (Album album : albumList) {
            System.out.println(album);
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