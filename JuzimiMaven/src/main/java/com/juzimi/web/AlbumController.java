package com.juzimi.web;

import com.juzimi.domain.Album;
import com.juzimi.domain.AlbumRequestByAuto;
import com.juzimi.domain.AutoAlbums;
import com.juzimi.domain.RequestByFirstPageDate;
import com.juzimi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/api")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/getalbumsbyclassifyid")
    @ResponseBody
    public List<Album> getalbumsbyclassifyid(String classifyid){
        System.out.println("来到了web层");
        System.out.println(classifyid);

        /* 调用serive */
        List<Album> albumsByClassifyId = albumService.getAlbumsByClassifyId(Integer.valueOf(classifyid));


        return albumsByClassifyId;
    }

    @RequestMapping("/autogetalbums")
    @ResponseBody
    public AutoAlbums autogetalbums(@RequestBody AlbumRequestByAuto albumRequestByAuto){
        // 分页查询请求
        System.out.println("来到了web层---------------");
        // 已成功获取到前端数据
        System.out.println(albumRequestByAuto);

        AutoAlbums autoAlbums = albumService.getAutoAlbums(albumRequestByAuto.getClassifyId(), albumRequestByAuto.getPageNum(), albumRequestByAuto.getPageSize());

        return autoAlbums;
    }

    // 搜索专辑
    @RequestMapping("/searchalbum")
    @ResponseBody
    public AutoAlbums searchalbum(@RequestBody RequestByFirstPageDate requestByFirstPageDate){
        AutoAlbums searchAlbum = albumService.getSearchAlbum(requestByFirstPageDate.getKeyy(), requestByFirstPageDate.getPageNum(), requestByFirstPageDate.getPageSize());
        return searchAlbum;
    }


    @RequestMapping("/selectalbumbyid")
    @ResponseBody
    public Album selectalbumbyid(Integer albumId){
        // 根据专辑id查
        System.out.println("来到了web层-----selectalbumbyid----");
        System.out.println(albumId);
        Album album = albumService.selectById(albumId);

        return album;
    }

    // 获取推荐专辑
    @RequestMapping("/getpushalbum")
    @ResponseBody
    public List<Album> getpushalbum(){
        List<Album> albumList = albumService.getPushAlbum();
        return albumList;
    }



}
