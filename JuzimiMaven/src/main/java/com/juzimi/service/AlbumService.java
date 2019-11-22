package com.juzimi.service;

import com.github.pagehelper.PageInfo;
import com.juzimi.domain.Album;
import com.juzimi.domain.AutoAlbums;
import com.juzimi.domain.Result;

import java.util.List;

public interface AlbumService {
    public List<Album> getAlbumsByClassifyId(Integer classifyId);
    public Integer save(Album album);
    public AutoAlbums getAutoAlbums(Integer classifyId, Integer pageNum, Integer pageSize);
    // 根据专辑id查
    public Album selectById(Integer albumId);
    // 获取所有专辑
    public PageInfo<Album> getAllAlbum(Integer pageNum, Integer pageSize);
    // 更新专辑
    public Result updataAlbum(Album album);
    // 删除专辑
    public  Result delAlbum(Album album);
    // 批量删除专辑
    public Result delSomeAlbum(List<Album> albumList);
    // 获取最推荐专辑
    public List<Album> getPushAlbum();
}
