package com.gaoxing.demo1;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public void save() {
        System.out.println("保存操作");
    }

    @Override
    public void updata() {
        System.out.println("更新操作");
    }
}
