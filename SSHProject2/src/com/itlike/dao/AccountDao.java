package com.itlike.dao;

import com.itlike.domain.Account;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.InternetHeaders;

import java.util.List;

public interface AccountDao {
    public void save(Account account);
    public void update(Account account);
    public void delete(Account account);
    public Account getById(Integer id);
    public List<Account> getAllAccount();
}
