package com.juzimi.web;

import com.juzimi.domain.RequestByFirstPageDate;
import com.juzimi.domain.ResultFirstPageData;
import com.juzimi.service.FirstPageDataSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("/api")
public class ResultFirstPageDataController {
    @Autowired
    private FirstPageDataSerive firstPageDataSerive;

    // 获取首页句子
    @RequestMapping("/getfirstpagedata")
    @ResponseBody
    public ResultFirstPageData getFirstPageData(@RequestBody RequestByFirstPageDate requestByFirstPageDate){
        System.out.println(requestByFirstPageDate);
        ResultFirstPageData firstPageData = firstPageDataSerive.getFirstPageData(requestByFirstPageDate.getUserId(), requestByFirstPageDate.getPageNum(), requestByFirstPageDate.getPageSize());

        return firstPageData;
    }

    // 搜索句子
    @RequestMapping("/getsearchsen")
    @ResponseBody
    public ResultFirstPageData getsearchsen(@RequestBody RequestByFirstPageDate requestByFirstPageDate){
        ResultFirstPageData resultFirstPageData = firstPageDataSerive.searchSen(requestByFirstPageDate.getUserId(), requestByFirstPageDate.getKeyy(), requestByFirstPageDate.getPageNum(), requestByFirstPageDate.getPageSize());
        return resultFirstPageData;
    }


    // 获取专辑页句子
    @RequestMapping("/getalbumpagedata")
    @ResponseBody
    public ResultFirstPageData getalbumpagedata(@RequestBody RequestByFirstPageDate requestByFirstPageDate){

        System.out.println(requestByFirstPageDate);
        ResultFirstPageData albumPagedata = firstPageDataSerive.getAlbumPagedata(requestByFirstPageDate.getUserId(), requestByFirstPageDate.getAlbumId(), requestByFirstPageDate.getPageNum(), requestByFirstPageDate.getPageSize());


        return albumPagedata;
    }

    // 获取用户发布的句子
    @RequestMapping("/getsenbyuserid")
    @ResponseBody
    public ResultFirstPageData getsenbyuserid(@RequestBody RequestByFirstPageDate requestByFirstPageDate){
        System.out.println(requestByFirstPageDate);
        ResultFirstPageData senByUserId = firstPageDataSerive.getSenByUserId(requestByFirstPageDate.getUserId(), requestByFirstPageDate.getPageNum(), requestByFirstPageDate.getPageSize());

        return senByUserId;
    }

    // 获取用户收藏的句子
    @RequestMapping("/getlikesenbyuserid")
    @ResponseBody
    public ResultFirstPageData getlikesenbyuserid(@RequestBody RequestByFirstPageDate requestByFirstPageDate){
        System.out.println(requestByFirstPageDate);
        ResultFirstPageData likeSenByUserIdRes = firstPageDataSerive.getLikeSenByUserId(requestByFirstPageDate.getUserId(), requestByFirstPageDate.getPageNum(), requestByFirstPageDate.getPageSize());
        return likeSenByUserIdRes;
    }





}
