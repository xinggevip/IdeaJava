package com.juzimi.web;

import com.juzimi.domain.Album;
import com.juzimi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/getalbumsbyclassifyid")
    public List<Album> getalbumsbyclassifyid(Integer classifyid){
        System.out.println("来到了web层");
        /* 调用serive */


        return null;
    }

}
