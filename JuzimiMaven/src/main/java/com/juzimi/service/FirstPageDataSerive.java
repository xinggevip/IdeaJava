package com.juzimi.service;

import com.juzimi.domain.ResultFirstPageData;

public interface FirstPageDataSerive {
    // 查首页句子
    public ResultFirstPageData getFirstPageData(String userId,Integer pageNum,Integer pageSize);
    // 查专辑页句子
    public  ResultFirstPageData getAlbumPagedata(String userId,Integer albumId,Integer pageNum,Integer pageSize);
    // 查用户发布的句子
    public  ResultFirstPageData getSenByUserId(String userId, Integer pageNum, Integer pageSize);

}
