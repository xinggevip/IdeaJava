package com.wf.sunflowers.controller;

import com.github.pagehelper.PageInfo;
import com.wf.sunflowers.domain.ResultInfo;
import com.wf.sunflowers.entity.TFlag;
import com.wf.sunflowers.entity.TFlagPro;
import com.wf.sunflowers.service.TFlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin
public class TFlagController {
    @Autowired
    private TFlagService tFlagService;

    // 批量删除flag
    @RequestMapping("/delflags")
    @ResponseBody
    public ResultInfo delflags(@RequestBody List<TFlag> flagList){
        ResultInfo resultInfo = tFlagService.delFlags(flagList);
        return resultInfo;
    }


    // 删除单个flag
    @RequestMapping("/delflag")
    @ResponseBody
    public ResultInfo delflag(@RequestBody TFlag tFlag){
        ResultInfo resultInfo = tFlagService.delFalg(tFlag);
        return resultInfo;
    }

    // 更新flag
    @RequestMapping("/updataflag")
    @ResponseBody
    public ResultInfo updataflag(@RequestBody TFlag tFlag){
        ResultInfo resultInfo = tFlagService.updataFlag(tFlag);
        return resultInfo;
    }

    // 获取所有flag
    @RequestMapping("/getallflag")
    @ResponseBody
    public PageInfo<TFlagPro> getallflag(Integer userid, String key, Integer pageNum, Integer pageSize){
        PageInfo<TFlagPro> pageInfo = tFlagService.getAllFlagByUidAndKey(userid, key, pageNum, pageSize);
        System.out.println(userid+key+pageNum+pageSize);
        return pageInfo;
    }

    // 发布句子
    @RequestMapping("/insertflag")
    @ResponseBody
    public ResultInfo insertflag(@RequestBody TFlag tFlag){
        ResultInfo resultInfo = tFlagService.insertFlag(tFlag);
        return resultInfo;
    }
}
