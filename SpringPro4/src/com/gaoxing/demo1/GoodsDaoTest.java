package com.gaoxing.demo1;

import org.junit.Test;

public class GoodsDaoTest {
    @Test
    public void tets1(){
        GoodsDao goodsDao = new GoodsDaoImpl();
//        goodsDao.save();
        // 获取代理对象
        GoodsDaoProxy daoProxy = new GoodsDaoProxy();
        GoodsDao goodsDao1 = daoProxy.createeProxy(goodsDao);
        goodsDao1.save();
        goodsDao1.updata();

    }
}
