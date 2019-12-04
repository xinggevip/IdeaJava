package com.wf.sunflowers.service;

import com.github.pagehelper.PageInfo;
import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TFlag;
import com.wf.sunflowers.entity.TFlagPro;

import java.util.List;

public interface TFlagService {
    // 根据用户id和搜索关键词获取所有任务
    public PageInfo<TFlagPro> getAllFlagByUidAndKey(Integer userid, String key, Integer pageNum, Integer pageSize);
    // 发布flag
    public ResultInfo insertFlag(TFlag tFlag);
    // 更新flag
    public ResultInfo updataFlag(TFlag tFlag);
    // 删除flag
    public ResultInfo delFalg(TFlag tFlag);
    // 批量删除flag
    public ResultInfo delFlags(List<TFlag> tFlags);
    // 批量设置flag完成状态
    public ResultInfo setFlagsState(List<TFlag> tFlags);
}
