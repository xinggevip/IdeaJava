package com.gaoxing.demo1;

import org.springframework.stereotype.Repository;

@Repository
public class GoodsDaoImpl implements GoodsDao {
    @Override
    public void save(int i,int j) {
        System.out.println("保存操作");
    }

    @Override
    public String update() {
        System.out.println("更新操作");
        return "update----res";
    }

    @Override
    public void delete() {
        System.out.println("删除操作");
    }

    @Override
    public void find() {
        System.out.println("查找操作");
//        int i = 1 / 0;
    }
}
