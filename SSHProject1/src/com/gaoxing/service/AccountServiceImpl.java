package com.gaoxing.service;

import com.gaoxing.domain.Account;

public class AccountServiceImpl implements AccountService {

    @Override
    public void save(Account account) {
        System.out.println("来到了业务层" + account);
    }
}
