package com.itlike.dao;

import com.itlike.domain.Account;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class AccountDaoImpl extends HibernateDaoSupport implements  AccountDao {
    @Override
    public void save(Account account) {
        System.out.println("AccountDaoImpl  保存到数据库当中 dao");
        this.getHibernateTemplate().save(account);
    }

    @Override
    public void update(Account account) {
        this.getHibernateTemplate().update(account);
    }

    @Override
    public void delete(Account account) {
        this.getHibernateTemplate().delete(account);
    }

    @Override
    public Account getById(Integer id) {
        Account account = this.getHibernateTemplate().get(Account.class, id);
        return account;
    }

    @Override
    public List<Account> getAllAccount() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Account.class);
        List<Account> list = (List<Account>)this.getHibernateTemplate().findByCriteria(detachedCriteria);
        return list;
    }
}
