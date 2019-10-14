package com.gaoxing.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GoodsTest {
    @Resource(name = "goodsDao")
    private GoodsDao goodsDao;
    @Test
    public void test(){
        goodsDao.save();
        goodsDao.update();
        goodsDao.delete();
        goodsDao.find();
    }
    /**
     * 日志
     * 保存操作
     * 更新操作
     * 后置通知update----res
     * delete----之前
     * 删除操作
     * delete----之后
     * 查找操作
     * 最终通知
     */
}
