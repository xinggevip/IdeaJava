package com.juzimi.service;

import com.juzimi.domain.Result;
import com.juzimi.domain.Userlikesen;
import com.juzimi.mapper.UserlikesenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserlikesenSeriveImpl implements UserlikesenSerive {

    @Autowired
    private UserlikesenMapper userlikesenMapper;

    @Override
    public Result toLike(Userlikesen userlikesen) {
        try {
            int insert = userlikesenMapper.insert(userlikesen);
            if (insert > 0){
                return new Result(true,"收藏成功",userlikesen.getUserLikesenId());
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new Result(false, "收藏失败", -100);
        }

        return new Result(false, "收藏失败", -100);
    }

    @Override
    public Result toNoLike(Userlikesen userlikesen) {
        try {
            int i = userlikesenMapper.deleteByUserIdSenId(userlikesen);
            if (i > 0){
                return new Result(true,"已取消收藏");
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new Result(false,"取消收藏失败");
        }
        return new Result(false,"取消收藏失败");
    }
}
