package com.itlike.dao;

import com.itlike.domain.Account;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;


public class AccountDaoImpl extends HibernateDaoSupport implements  AccountDao {
    @Override
    public void save(Account account) {
        System.out.println("AccountDaoImpl  保存到数据库当中 dao");
        this.getHibernateTemplate().save(account);
    }
}
