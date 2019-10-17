package com.gaoxing.service;

import com.gaoxing.dao.AccountDao;
import com.gaoxing.dao.AccountDaoImpl;
import com.gaoxing.domain.Account;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save(Account account) {
        System.out.println("来到了业务层" + account);
        accountDao.save(account);
    }
}
