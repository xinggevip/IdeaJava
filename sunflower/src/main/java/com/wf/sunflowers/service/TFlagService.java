package com.wf.sunflowers.service;

import com.github.pagehelper.PageInfo;
import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TFlag;
import com.wf.sunflowers.entity.TFlagPro;

public interface TFlagService {
    // 根据用户id和搜索关键词获取所有任务
    public PageInfo<TFlagPro> getAllFlagByUidAndKey(Integer userid, String key, Integer pageNum, Integer pageSize);
    // 发布flag
    public ResultInfo insertFlag(TFlag tFlag);
}
