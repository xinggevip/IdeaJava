package com.gaoxing.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class PageBean {
    // 当前是哪一页
    private Integer currentPage;
    // 共多少页
    private Integer totalPage;
    // 共多少纪录
    private Integer totalCount;
    // 当前页商品
    private List<Goods> goodsList = new ArrayList<>();

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", goodsList=" + goodsList +
                '}';
    }
}
