package com.juzimi.mapper;

import com.juzimi.domain.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumMapper {
    int deleteByPrimaryKey(Integer albumId);

    int insert(Album record);

    Album selectByPrimaryKey(Integer albumId);

    List<Album> selectAll();

    int updateByPrimaryKey(Album record);

    /* 根据分类id查专辑 */
    List<Album> selectAlbumByClassifyId(Integer classifyId);

    // 获取热门专辑
    List<Album> selectHotAlbum();

    // 搜索专辑
    List<Album> selectSearchAlbums(@Param("key") String key);
}