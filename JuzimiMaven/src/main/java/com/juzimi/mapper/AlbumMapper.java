package com.juzimi.mapper;

import com.juzimi.domain.Album;
import java.util.List;

public interface AlbumMapper {
    int deleteByPrimaryKey(Integer albumId);

    /* 插入一条数据并获取自增的id */
    Integer insert(Album record);

    /* 根据专辑id查一个专辑记录 */
    Album selectByPrimaryKey(Integer albumId);

    /* 获取所有专辑记录 */
    List<Album> selectAll();

    /* 更新一个专辑 */
    int updateByPrimaryKey(Album record);

    /* 根据分类id查专辑 */
    List<Album> selectAlbumByClassifyId(Integer classifyId);
}