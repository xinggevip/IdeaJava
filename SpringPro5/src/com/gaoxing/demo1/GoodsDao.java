package com.gaoxing.demo1;

import org.springframework.stereotype.Component;

@Component
public interface GoodsDao {
    public void save(int i,int j);
    public String update();
    public void delete();
    public void find();
}
