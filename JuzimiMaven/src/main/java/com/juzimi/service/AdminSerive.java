package com.juzimi.service;

import com.github.pagehelper.PageInfo;
import com.juzimi.domain.*;

import java.util.List;

public interface AdminSerive {
    public Admin login(Admin admin);
    public PageInfo getUserListResult(Integer pageNum, Integer pageSize);
    // 批量设置激活
    public Result setYesActive(List<Users> usersList);
    // 删除
    public Result delOneUser(Users user);
    // 批量删除
    public Result delSomeUser(List<Users> usersList);
    // 分页获取句子
    public PageInfo getSentenceResult(Integer pageNum,Integer pageSize);
    // 分页获取句子带专辑名称
    public PageInfo getSensPro(Integer pageNum,Integer pageSize);
    // 更新管理员（开始关闭审核状态）
    public Result updataAdmin(Admin admin);
    // 获取统计信息
    public CountResult getCountResult();
    // 统计新增数据
    public List<CountListResult> getCountListResult(Integer num);
    // 根据id或姓名搜索用户
    public PageInfo<Users> searchUsersByIdOrName(String key,Integer pageNum,Integer pageSize);

}
