package com.juzimi.test;

import com.github.pagehelper.PageInfo;
import com.juzimi.domain.Album;
import com.juzimi.domain.AutoAlbums;
import com.juzimi.service.AlbumService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class AlbumTest {
    // 搜索专辑
    @Test
    public void getSearchAlbum(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AlbumService albumService = springApp.getBean(AlbumService.class);
        AutoAlbums albums = albumService.getSearchAlbum("的", 1, 10);
        for (Album album : albums.getAlbumList()) {
            System.out.println(album);
        }
        System.out.println(albums.getNext());
    }
    @Test
    public void getAllAlbumTest(){
        // 管理员登录测试
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AlbumService albumService = springApp.getBean(AlbumService.class);
        PageInfo<Album> pageInfo = albumService.getAllAlbum(1, 10);
        for (Album album : pageInfo.getList()) {
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

    @Test
    public void getPushAlbum(){
        // 获取推荐列表测试
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        AlbumService albumService = springApp.getBean(AlbumService.class);
        List<Album> albumList = albumService.getPushAlbum();
        for (Album album : albumList) {
            System.out.println(album);
        }
    }
}
