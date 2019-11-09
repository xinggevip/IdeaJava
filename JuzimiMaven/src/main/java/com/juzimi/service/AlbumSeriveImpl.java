package com.juzimi.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.juzimi.domain.Album;
import com.juzimi.domain.AutoAlbums;
import com.juzimi.mapper.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class AlbumSeriveImpl implements AlbumService {
    @Autowired
    private AlbumMapper albumMapper;

    @Autowired AutoAlbums autoAlbums;


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

    @Override
    public AutoAlbums getAutoAlbums(Integer classifyId, Integer pageNum, Integer pageSize) {

        /* 配置分页查询 从第几页开始查，一页查多少条记录 */
        String orderBy = "album_id  desc";//按照排序字段 倒序 排序
        Page<Album> pageIn = PageHelper.startPage(pageNum,pageSize,orderBy);

        List<Album> albumList = getAlbumsByClassifyId(classifyId);
        // 集合反转
//        Collections.reverse(albumList);

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


        autoAlbums.setAlbumList(albumList);
        autoAlbums.setNext(pageInfo.isHasNextPage());


        return autoAlbums;
    }

    @Override
    public Album selectById(Integer albumId) {
        Album album = albumMapper.selectByPrimaryKey(albumId);
        return album;
    }


}
