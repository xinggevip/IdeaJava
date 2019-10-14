package com.gaoxing.demo2;

import com.gaoxing.demo1.GoodsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopTest {
    @Resource(name = "goodsDao")
    private GoodsDao goodsDao;
    @Test
    public void test1(){
        this.goodsDao.save();
        this.goodsDao.updata();
    }
}
