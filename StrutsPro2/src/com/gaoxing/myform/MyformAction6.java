package com.gaoxing.myform;

import com.gaoxing.domain.Goods;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class MyformAction6 extends ActionSupport {
    private List<Goods> goodsList;

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public String execute(){
        System.out.println(goodsList);
        return null;
    }
}
