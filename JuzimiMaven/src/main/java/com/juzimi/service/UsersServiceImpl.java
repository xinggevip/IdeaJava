package com.juzimi.service;

import com.juzimi.domain.Users;
import com.juzimi.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users login(Users user) {
        System.out.println("来到了service----login");
        Users loginUser = usersMapper.selectByIdBypassword(user);
        System.out.println("service--loginUser" + loginUser);
        return loginUser;
    }

    @Override
    public String register(Users user) {
        System.out.println("serive--register---" + user);

        try {
            int insert = usersMapper.insert(user);
            System.out.println("serive----register-----" + insert);

            if (insert > 0){
                return "success";
            }
        }catch (Exception e){
            return "fail";
        }

        return "fail";
    }
}
