package com.juzimi.mapper;

import com.juzimi.domain.FirstPageData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FirstPageDataMapper {
    // 查找首页中的所有句子
    public List<FirstPageData> selectFirstPageData(String userId);

    // 查找专辑中的所有句子
    public List<FirstPageData> selectAlbumPageData(@Param("userId") String userId, @Param("albumId") Integer albumId);
}
