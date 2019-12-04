package com.wf.sunflowers.service;

import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TType;

import java.util.List;

public interface TTypeService {
    // 获取所有时间类型
    public List<TType> getAllTtypes();
    // 更新和添加任务
    public ResultInfo setAndAdd(List<TType> list);
}
