package com.juzimi.service;

import com.juzimi.domain.Result;
import com.juzimi.domain.Sentence;
import com.juzimi.mapper.SentenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
@Transactional
public class SentenceSeriveImpl implements SentenceSerive {

    @Autowired
    private SentenceMapper sentenceMapper;

    @Override
    public Result addSentence(Sentence sentence) {

        try {
            //时间转换
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            //上传时间
            sentence.setCreateDate(Timestamp.valueOf(nowTime));

            int insert = sentenceMapper.insert(sentence);
            if(insert > 0){
                System.out.println("发布成功");
                return new Result(true,"发布成功",sentence.getSentenceId());

            }else {
                System.out.println("发布失败");
                return new Result(false,"发布失败",-1);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new Result(false,"发布失败",-1);
        }


    }
}
