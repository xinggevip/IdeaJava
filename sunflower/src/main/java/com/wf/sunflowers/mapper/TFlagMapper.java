package com.wf.sunflowers.mapper;

import com.wf.sunflowers.entity.TFlag;
import com.wf.sunflowers.entity.TFlagPro;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TFlagMapper {
    int deleteByPrimaryKey(Integer fid);

    // 发布flag
    int insert(TFlag record);

    TFlag selectByPrimaryKey(Integer fid);

    List<TFlag> selectAll();

    int updateByPrimaryKey(TFlag record);

    // 根据用户id和搜索关键词获取所有任务
    List<TFlagPro> selectAllByUidAndKey(@Param("userid") Integer userid, @Param("key") String key);

}