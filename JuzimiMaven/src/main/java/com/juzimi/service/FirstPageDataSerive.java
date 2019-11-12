package com.juzimi.service;

import com.juzimi.domain.ResultFirstPageData;

public interface FirstPageDataSerive {
    public ResultFirstPageData getFirstPageData(String userId,Integer pageNum,Integer pageSize);

    public  ResultFirstPageData getAlbumPagedata(String userId,Integer albumId,Integer pageNum,Integer pageSize);
}
