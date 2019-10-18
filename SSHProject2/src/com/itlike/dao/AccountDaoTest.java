package com.itlike.dao;

import com.itlike.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountDaoTest {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Test
    public void test(){
        // 查找
        Account account = accountDao.getById(1);
        System.out.println(account);

        // 更新
        account.setMoney(500d);
        accountDao.update(account);

        // 删除
        // accountDao.delete(account);


    }

    @Test
    public void test2(){
        List<Account> allAccount = accountDao.getAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }
}
