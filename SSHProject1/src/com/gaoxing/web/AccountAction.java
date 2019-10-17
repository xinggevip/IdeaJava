package com.gaoxing.web;

import com.gaoxing.domain.Account;
import com.gaoxing.service.AccountService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AccountAction extends ActionSupport implements ModelDriven<Account> {
    private Account account = new Account();
    @Override
    public Account getModel() {
        return account;
    }

    // 不用再通过spring获取对象，通过struts2-spring-插件自动注入获取对象
    AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public String save(){
        /*System.out.println("AccountAction-----save");
        System.out.println(account);*/

        /*// 通过spring获取对象
        ServletContext servletContext = ServletActionContext.getServletContext();
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        // 获取对象
        AccountService accountService = (AccountService)applicationContext.getBean("accountService");
        accountService.save(account);*/
        accountService.save(account);
        return null;
    }




}
