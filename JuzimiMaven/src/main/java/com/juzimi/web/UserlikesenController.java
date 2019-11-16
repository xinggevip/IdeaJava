package com.juzimi.web;

import com.juzimi.domain.Result;
import com.juzimi.domain.Userlikesen;
import com.juzimi.service.UserlikesenSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
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

    @RequestMapping("/tonolike")
    @ResponseBody
    public Result tonolike(@RequestBody Userlikesen userlikesen){
        System.out.println(userlikesen);
        Result result = userlikesenSerive.toNoLike(userlikesen);
        return result;
    }
}
