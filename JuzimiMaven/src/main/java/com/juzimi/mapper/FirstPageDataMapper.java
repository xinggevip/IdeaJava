package com.juzimi.mapper;

import com.juzimi.domain.FirstPageData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FirstPageDataMapper {
    // 查找首页中的所有句子
    public List<FirstPageData> selectFirstPageData(String userId);

    // 搜索句子
    public List<FirstPageData> selectSearchSen(@Param("userId") String userId, @Param("key") String key);

    // 查找专辑中的所有句子
    public List<FirstPageData> selectAlbumPageData(@Param("userId") String userId, @Param("albumId") Integer albumId);

    // 根据用户id查句子
    public List<FirstPageData> selectSenByUserId(String userId);

    // 查根据用户id询用户已收藏的句子
    public List<FirstPageData> selectLikeSenByUserId(String userId);

}
