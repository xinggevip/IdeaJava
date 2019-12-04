package com.wf.sunflowers.test;

import com.wf.sunflowers.entity.TType;
import com.wf.sunflowers.service.TTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TTypeTest {
    @Test
    public void getALlTtypes(){
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        TTypeService tTypeService = springApp.getBean(TTypeService.class);
        List<TType> allTtypes = tTypeService.getAllTtypes();
        for (TType allTtype : allTtypes) {
            System.out.println(allTtype);
        }
    }

    @Test
    public void test1(){
        TType tType = new TType();
        tType.setTname("哈哈");
        Integer tid = tType.getTid();
        System.out.println(tid);
    }
}
