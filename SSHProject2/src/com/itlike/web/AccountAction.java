package com.itlike.web;
import com.itlike.domain.Account;
import com.itlike.service.AccountService;
import com.itlike.service.AccountServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

public class AccountAction extends ActionSupport implements ModelDriven<Account> {
    private Account account = new Account();
    @Override
    public Account getModel() {
        return account;
    }

    //自动注入
    AccountService accountService;
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public String save(){
        accountService.save(account);
        return  null;
    }



}
