package com.juzimi.service;

import com.juzimi.domain.Admin;
import com.juzimi.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminSeriveImpl implements AdminSerive {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        try {
            Admin admin1 = adminMapper.selectByUidWidthPwd(admin);
            return admin1;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}
