package com.juzimi.service;

import com.juzimi.domain.Album;
import com.juzimi.mapper.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumSeriveImpl implements AlbumService {
    @Autowired
    private AlbumMapper albumMapper;


    @Override
    public List<Album> getAlbumsByClassifyId(Integer classifyId) {
        System.out.println("来到了serive");
        List<Album> albums = albumMapper.selectAlbumByClassifyId(classifyId);
        System.out.println("serive----------albums--------------" + albums);
        return albums;
    }

    @Override
    public Integer save(Album album) {
        try {
            System.out.println("1");
            // 这个返回的是插入了几条记录
            int insert = albumMapper.insert(album);
            System.out.println("插入了------------" + insert + "条记录");
            System.out.println("获取最后插入的id为：----------" + album.getAlbumId());
            if (album.getAlbumId() > 0){
                return album.getAlbumId();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        return -1;
    }
}
