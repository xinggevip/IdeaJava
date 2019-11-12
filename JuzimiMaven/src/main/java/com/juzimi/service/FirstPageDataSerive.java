package com.juzimi.service;

import com.juzimi.domain.ResultFirstPageData;

public interface FirstPageDataSerive {
    public ResultFirstPageData getFirstPageData(String userId,Integer pageNum,Integer pagesize);
}
