package com.juzimi.mapper;

import com.juzimi.domain.Album;
import java.util.List;

public interface AlbumMapper {
    int deleteByPrimaryKey(Integer albumId);

    int insert(Album record);

    Album selectByPrimaryKey(Integer albumId);

    List<Album> selectAll();

    int updateByPrimaryKey(Album record);

    /* 根据分类id查专辑 */
    List<Album> selectAlbumByClassifyId(Integer classifyId);
}