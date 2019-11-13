package com.juzimi.test;

import com.juzimi.domain.FirstPageData;
import com.juzimi.domain.Result;
import com.juzimi.domain.ResultFirstPageData;
import com.juzimi.domain.Sentence;
import com.juzimi.service.FirstPageDataSerive;
import com.juzimi.service.SentenceSerive;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SentenceTest {


    @Test
    public void delSenTest(){
        // 删除句子
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        SentenceSerive sentenceSerive = springApp.getBean(SentenceSerive.class);

        Result result = sentenceSerive.delSentenceById(50);
        System.out.println(result);


    }

    @Test
    public void updataSen(){
        // 更新句子
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        SentenceSerive sentenceSerive = springApp.getBean(SentenceSerive.class);


        Sentence sentence = new Sentence();
        sentence.setSentenceId(41);
        sentence.setSentenceTxt("人生一切难题，知识给你答案");
        sentence.setUserId("xing");
        sentence.setAuthorName("李笑来");
        sentence.setAlbumId(7);
        sentence.setClassfiyId(1);

        sentenceSerive.updataSen(sentence);

    }

    @Test
    public void getSenByUserIdTest(){
        // 根据用户id查句子
        ClassPathXmlApplicationContext springApp = new ClassPathXmlApplicationContext("applicationContext.xml");
        FirstPageDataSerive firstPageDataSerive = springApp.getBean(FirstPageDataSerive.class);

        ResultFirstPageData userSenRes = firstPageDataSerive.getSenByUserId("xinggevip", 1, 10);
        for (FirstPageData firstPageData : userSenRes.getFirstPageDataList()) {
            System.out.println(firstPageData);
        }
        System.out.println(userSenRes.getNext());


    }

}
