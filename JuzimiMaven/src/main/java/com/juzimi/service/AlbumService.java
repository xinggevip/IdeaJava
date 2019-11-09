package com.juzimi.service;

import com.juzimi.domain.Album;
import com.juzimi.domain.AutoAlbums;

import java.util.List;

public interface AlbumService {
    public List<Album> getAlbumsByClassifyId(Integer classifyId);
    public Integer save(Album album);
    public AutoAlbums getAutoAlbums(Integer classifyId, Integer pageNum, Integer pageSize);
}
