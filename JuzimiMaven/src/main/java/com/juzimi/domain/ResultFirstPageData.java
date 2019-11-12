package com.juzimi.domain;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultFirstPageData {
    private List<FirstPageData> firstPageDataList = new ArrayList<>();
    Boolean next;

    public List<FirstPageData> getFirstPageDataList() {
        return firstPageDataList;
    }

    public void setFirstPageDataList(List<FirstPageData> firstPageDataList) {
        this.firstPageDataList = firstPageDataList;
    }

    public Boolean getNext() {
        return next;
    }

    public void setNext(Boolean next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ResultFirstPageData{" +
                "firstPageDataList=" + firstPageDataList +
                ", next=" + next +
                '}';
    }
}
