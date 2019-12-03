package com.wf.sunflowers.mapper;

import com.wf.sunflowers.entity.TType;
import java.util.List;

public interface TTypeMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(TType record);

    TType selectByPrimaryKey(Integer tid);

    List<TType> selectAll();

    int updateByPrimaryKey(TType record);
}