package com.juzimi.service;

import com.juzimi.domain.ResultFirstPageData;

public interface FirstPageDataSerive {
    // 查首页句子
    public ResultFirstPageData getFirstPageData(String userId,Integer pageNum,Integer pageSize);
    // 查专辑页句子
    public  ResultFirstPageData getAlbumPagedata(String userId,Integer albumId,Integer pageNum,Integer pageSize);
    // 查用户发布的句子
    public  ResultFirstPageData getSenByUserId(String userId, Integer pageNum, Integer pageSize);
    // 查用户收藏的句子
    public ResultFirstPageData getLikeSenByUserId(String userId, Integer pageNum, Integer pageSize);
    // 搜索句子
    public ResultFirstPageData searchSen(String userId,String key, Integer pageNum, Integer pageSize);

}
