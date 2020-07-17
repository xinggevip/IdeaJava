package com.gaoxing.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GoodsTest {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private UserDao userDao;
    @Test
    public void test(){
        goodsDao.save(1,2);
        goodsDao.update();
        goodsDao.delete();
        goodsDao.find();

        userDao.save();
    }
    /**
     * 日志
     * 保存操作
     * 更新操作
     * 后置通知update----res
     * delete----之前
     * 删除操作
     * delete----之后
     * 日志
     * 查找操作
     * 最终通知
     * 日志
     * UserDao--save
     *
     * 有接口使用技术为jdk动态代理
     * 无接口使用的技术为Cglib
     */
}
