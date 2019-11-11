package com.juzimi.mapper;

import com.juzimi.domain.Admin;
import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(String adminId);

    int insert(Admin record);

    Admin selectByPrimaryKey(String adminId);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin record);
}