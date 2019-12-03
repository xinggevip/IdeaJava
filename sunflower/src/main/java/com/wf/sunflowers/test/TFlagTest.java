package com.wf.sunflowers.test;

import com.github.pagehelper.PageInfo;
import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TFlag;
import com.wf.sunflowers.entity.TFlagPro;
import com.wf.sunflowers.service.TFlagService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;

public class TFlagTest {
    // 更新flag
    @Test
    public void updataFlag(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        TFlagService tFlagService = springApp.getBean(TFlagService.class);
        TFlag flag = new TFlag();
        flag.setFid(11);
        flag.setHname("学习数学");
        flag.setTypeid(1);
        flag.setHdate(new Date());
        flag.setImplement("学会数理化，走遍天下都不怕");
        flag.setWord("不蒸馒头争口气");
        flag.setUserid(3);
        flag.setClick(1);
        ResultInfo resultInfo = tFlagService.updataFlag(flag);
        System.out.println(resultInfo);
    }

    // 获取所有flag
    @Test
    public void getAllFlagByUidAndKey(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        TFlagService tFlagService = springApp.getBean(TFlagService.class);
        PageInfo<TFlagPro> pageInfo = tFlagService.getAllFlagByUidAndKey(3, "做", 1, 10);
        for (TFlagPro tFlagPro : pageInfo.getList()) {
            System.out.println(tFlagPro);
        }

        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("每页显示记录数:"+pageInfo.getPageSize());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总记录数:"+pageInfo.getTotal());
        System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
        System.out.println("是否有下一页:"+pageInfo.isHasNextPage());
        System.out.println("导航页码:"+ Arrays.toString(pageInfo.getNavigatepageNums()));
    }

    // 发布flag
    @Test
    public void insertFlag(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        TFlagService tFlagService = springApp.getBean(TFlagService.class);
        TFlag flag = new TFlag();
        flag.setHdate(new Date());
        flag.setHname("学习java");
        flag.setImplement("学就完事了");
        flag.setTypeid(1);
        flag.setUserid(3);
        flag.setWord("学习学习再学习");
        ResultInfo resultInfo = tFlagService.insertFlag(flag);
        System.out.println(resultInfo);
    }
}
