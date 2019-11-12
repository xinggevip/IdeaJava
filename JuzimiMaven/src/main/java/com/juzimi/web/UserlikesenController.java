package com.juzimi.web;

import com.juzimi.domain.Result;
import com.juzimi.domain.Userlikesen;
import com.juzimi.service.UserlikesenSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserlikesenController {
    @Autowired
    private UserlikesenSerive userlikesenSerive;
    @RequestMapping("/tolike")
    @ResponseBody
    public Result tolike(@RequestBody Userlikesen userlikesen){
        System.out.println(userlikesen);
        Result result = userlikesenSerive.toLike(userlikesen);
        return result;
    }

}
