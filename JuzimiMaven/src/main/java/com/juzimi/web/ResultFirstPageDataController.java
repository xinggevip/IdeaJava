package com.juzimi.web;

import com.juzimi.domain.RequestByFirstPageDate;
import com.juzimi.domain.ResultFirstPageData;
import com.juzimi.service.FirstPageDataSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ResultFirstPageDataController {
    @Autowired
    private FirstPageDataSerive firstPageDataSerive;

    @RequestMapping("/getfirstpagedata")
    @ResponseBody
    public ResultFirstPageData getFirstPageData(@RequestBody RequestByFirstPageDate requestByFirstPageDate){
        System.out.println(requestByFirstPageDate);
        ResultFirstPageData firstPageData = firstPageDataSerive.getFirstPageData(requestByFirstPageDate.getUserId(), requestByFirstPageDate.getPageNum(), requestByFirstPageDate.getPageSize());

        return firstPageData;
    }


}
