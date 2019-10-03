package com.gaoxing.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class PageBean {
    // ��ǰ����һҳ
    private Integer currentPage;
    // ������ҳ
    private Integer totalPage;
    // �����ټ�¼
    private Integer totalCount;
    // ��ǰҳ��Ʒ
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
