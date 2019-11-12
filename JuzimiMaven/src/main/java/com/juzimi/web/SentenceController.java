package com.juzimi.web;

import com.juzimi.domain.*;
import com.juzimi.service.SentenceSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class SentenceController {

    @Autowired
    private SentenceSerive sentenceSerive;

    @RequestMapping("/addsentence")
    @ResponseBody
    public Result addsentence(@RequestBody Sentence sentence){
        System.out.println(sentence);
        Result result = sentenceSerive.addSentence(sentence);
        return result;
    }

    @RequestMapping("/selectsentencebyalbumid")
    @ResponseBody
    public AutoSentence selectsentencebyalbumid(@RequestBody SentenceRequestByAuto sentenceRequestByAuto){
        // 经测试成功获取到前端的传参
        System.out.println(sentenceRequestByAuto);
        // 调用service层
        AutoSentence autoSentence = sentenceSerive.selectSentenceByAlbumId(sentenceRequestByAuto.getAlbumId(), sentenceRequestByAuto.getPageNum(), sentenceRequestByAuto.getPageSize());

        return autoSentence;
    }

    @RequestMapping("/selectsentencecount")
    @ResponseBody
    public SentenceCount selectsentencecount(Integer albumId){
        /* 根据专辑id查询记录个数 */
        System.out.println("===========+++++++++++++++++++++====================");
        System.out.println(albumId);
        SentenceCount sentenceCount = sentenceSerive.selectSentenceCount(albumId);

        return sentenceCount;
    }


    @RequestMapping("/selectallsentence")
    @ResponseBody
    public AutoSentencePro selectallsentence(@RequestBody SentenceRequestByAuto sentenceRequestByAuto) {
        // 经测试已接收到前端传参
        System.out.println(sentenceRequestByAuto);

        AutoSentencePro autoSentencePro = sentenceSerive.selectAllSentence(sentenceRequestByAuto.getPageNum(), sentenceRequestByAuto.getPageSize());



        return autoSentencePro;
    }

    @RequestMapping("/delsenbysenid")
    @ResponseBody
    public Result delsenbysenid(Integer sentenceId){
        Result result = sentenceSerive.delSentenceById(sentenceId);

        return result;
    }

}
