package com.juzimi.mapper;

import com.juzimi.domain.Userlikesen;
import java.util.List;

public interface UserlikesenMapper {
    // 根据收藏id删除
    int deleteByPrimaryKey(Integer userLikesenId);
    // 根据句子id删除
    int deleteBySenId(Integer sentenceId);
    // 添加收藏
    int insert(Userlikesen record);

    Userlikesen selectByPrimaryKey(Integer userLikesenId);

    List<Userlikesen> selectAll();

    int updateByPrimaryKey(Userlikesen record);

    // 根据用户名和句子id删除  取消收藏功能
    int deleteByUserIdSenId(Userlikesen userlikesen);
}