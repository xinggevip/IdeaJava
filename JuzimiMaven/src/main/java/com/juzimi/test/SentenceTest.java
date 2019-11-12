package com.juzimi.test;

import com.juzimi.domain.Result;
import com.juzimi.service.SentenceSerive;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SentenceTest {
    @Test
    public void delSenTest(){
        // 删除句子
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        SentenceSerive sentenceSerive = springApp.getBean(SentenceSerive.class);

        Result result = sentenceSerive.delSentenceById(50);
        System.out.println(result);


    }
}
