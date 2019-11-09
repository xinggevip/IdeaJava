package com.juzimi.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.juzimi.domain.AutoSentence;
import com.juzimi.domain.Result;
import com.juzimi.domain.Sentence;
import com.juzimi.domain.SentenceCount;
import com.juzimi.mapper.SentenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class SentenceSeriveImpl implements SentenceSerive {

    @Autowired
    private SentenceMapper sentenceMapper;
    @Autowired
    private AutoSentence autoSentence;
    @Autowired
    private SentenceCount sentenceCount;

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

    @Override
    public AutoSentence selectSentenceByAlbumId(Integer albumId, Integer pageNum, Integer pageSize) {

        /* 配置分页查询 从第几页开始查，一页查多少条记录 */
        String orderBy = "sentence_id  desc";//按照排序字段 倒序 排序
        Page<Sentence> pageIn = PageHelper.startPage(pageNum,pageSize,orderBy);

        List<Sentence> sentenceList = sentenceMapper.selectByAlbumId(albumId);
        // 集合反转
//        Collections.reverse(albumList);

        /* 信息更加详细 配置导航显示几条页码 */
        PageInfo<Sentence> pageInfo = new PageInfo<>(sentenceList, 3);

        for (Sentence sentence : sentenceList) {
            System.out.println(sentence);
        }

        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("每页显示记录数:"+pageInfo.getPageSize());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总记录数:"+pageInfo.getTotal());
        System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
        System.out.println("是否有下一页:"+pageInfo.isHasNextPage());
        System.out.println("导航页码:"+ Arrays.toString(pageInfo.getNavigatepageNums()));

        autoSentence.setSentenceList(sentenceList);
        autoSentence.setNext(pageInfo.isHasNextPage());

        return autoSentence;
    }

    @Override
    public SentenceCount selectSentenceCount(Integer albumId) {
        /* 根据专辑id查询记录个数 */
        int count = sentenceMapper.selectSentenceCount(albumId);
        sentenceCount.setSentenceCount(count);
        return sentenceCount;
    }


}
