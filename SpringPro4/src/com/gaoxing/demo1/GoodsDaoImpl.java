package com.gaoxing.demo1;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public String save() {
        System.out.println("保存操作");
        return "save---res";
    }

    @Override
    public void updata() {
        System.out.println("更新操作");
    }

    @Override
    public void delete() {
        System.out.println("删除操作");
    }

    @Override
    public void find() {
        System.out.println("find");
//        int i = 1 / 0;
    }
}
