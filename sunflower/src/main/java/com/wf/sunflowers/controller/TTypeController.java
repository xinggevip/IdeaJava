package com.wf.sunflowers.controller;


import com.wf.sunflowers.entity.TType;
import com.wf.sunflowers.service.TTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin
public class TTypeController {
    @Autowired
    private TTypeService tTypeService;

    // 获取所有任务
    @RequestMapping("/getallttypes")
    @ResponseBody
    public List<TType> getallttypes(){
        List<TType> allTtypes = tTypeService.getAllTtypes();
        return allTtypes;
    }
}
