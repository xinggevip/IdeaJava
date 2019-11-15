package com.juzimi.service;

import com.juzimi.domain.Users;

public interface UsersService {
    public Users login(Users user);
    public String register(Users user);
    // 根据用户id获取用户信息
    public Users getProFile(String userId);
}
