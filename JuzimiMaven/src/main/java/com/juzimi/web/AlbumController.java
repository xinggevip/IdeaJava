package com.juzimi.web;

import com.juzimi.domain.Album;
import com.juzimi.domain.AlbumRequestByAuto;
import com.juzimi.domain.AutoAlbums;
import com.juzimi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
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



}
