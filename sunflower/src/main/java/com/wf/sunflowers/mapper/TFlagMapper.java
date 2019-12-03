package com.wf.sunflowers.mapper;

import com.wf.sunflowers.entity.TFlag;
import java.util.List;

public interface TFlagMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(TFlag record);

    TFlag selectByPrimaryKey(Integer fid);

    List<TFlag> selectAll();

    int updateByPrimaryKey(TFlag record);
}