package com.gaoxing.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class AccountTest {
    @Resource(name = "accountService")
    private AccountService accountService;
    @Test
    public void test1(){
        accountService.transferMoney("高星1","高星2",100d);
    }
}
