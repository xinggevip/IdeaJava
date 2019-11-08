package com.juzimi.service;

import com.juzimi.domain.Users;

public interface UsersService {
    public Users login(Users user);
    public String register(Users user);
}
