package com.gaoxing.demo4;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transferMoney(String from, String to, Double money) {

        accountDao.minusMoney(from,money);
        // int i = 1 / 0;
        accountDao.addMoney(to,money);


    }
}
