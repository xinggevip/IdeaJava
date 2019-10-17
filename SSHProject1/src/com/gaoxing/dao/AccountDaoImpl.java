package com.gaoxing.dao;

import com.gaoxing.domain.Account;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void save(Account account) {
        System.out.println("来到了dao层" + account);
    }
}
