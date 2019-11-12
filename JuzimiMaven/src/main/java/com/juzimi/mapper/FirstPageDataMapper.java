package com.juzimi.mapper;

import com.juzimi.domain.FirstPageData;

import java.util.List;

public interface FirstPageDataMapper {
    public List<FirstPageData> selectFirstPageData(String userId);

}
