package com.juzimi.mapper;

import com.juzimi.domain.Users;
import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(String userId);

    int insert(Users record);

    Users selectByPrimaryKey(String userId);

    List<Users> selectAll();

    int updateByPrimaryKey(Users record);

    /* 登录 */
    Users selectByIdBypassword(Users user);
}