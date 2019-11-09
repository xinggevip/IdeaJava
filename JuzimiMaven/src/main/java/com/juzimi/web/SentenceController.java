package com.juzimi.web;

import com.juzimi.domain.AutoSentence;
import com.juzimi.domain.Result;
import com.juzimi.domain.Sentence;
import com.juzimi.domain.SentenceRequestByAuto;
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


}
