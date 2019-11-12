package com.juzimi.service;

import com.juzimi.domain.Result;
import com.juzimi.domain.Userlikesen;

public interface UserlikesenSerive {
    /**
     * 返回：
     * result success message
     */

    // 收藏
    public Result toLike(Userlikesen userlikesen);

    // 取消收藏
    public Result toNoLike(Userlikesen userlikesen);

}
