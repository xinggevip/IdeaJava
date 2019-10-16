package com.gaoxing.demo3;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    // 继承JdbcDaoSupport，可以不用写set方法也能注入
    /*private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    @Override
    public void addMoney(String name, Double money) {
        this.getJdbcTemplate().update("update account set money=money+? where name=?",money,name);
    }

    @Override
    public void minusMoney(String name, Double money) {
        this.getJdbcTemplate().update("update account set money=money-? where name=?",money,name);
    }
}
