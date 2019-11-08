package com.juzimi;

import com.juzimi.domain.Users;
import com.juzimi.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

//    @Test
//    public void test(){
//        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AlbumService albumService = springApp.getBean(AlbumService.class);
//        Album album = new Album();
//        album.setAlbumName("专辑名称");
//        album.setAlbumDetails("专辑详情");
//        album.setAlbumPicture("/upload/xxoo.jpg");
//        album.setClassifyId(1);
//
//    }


}
