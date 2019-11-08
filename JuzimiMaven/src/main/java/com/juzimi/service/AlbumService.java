package com.juzimi.service;

import com.juzimi.domain.Album;

import java.util.List;

public interface AlbumService {
    public List<Album> getAlbumsByClassifyId(Integer classifyId);
    public Integer save(Album album);
}
