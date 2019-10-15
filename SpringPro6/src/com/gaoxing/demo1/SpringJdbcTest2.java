package com.gaoxing.demo1;

import com.gaoxing.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJdbcTest2 {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    // 插入
    @Test
    public void test1(){
        jdbcTemplate.update("insert into account values (null,?,?)","高星3",999d);
    }

    // 删除
    @Test
    public void test2(){
        jdbcTemplate.update("delete from account where id=?",2);
    }

    // 更新
    @Test
    public void test3(){
        jdbcTemplate.update("update account set name=?,money=? where id=?","油条",666d,1);
    }

    // 根据id查询记录
    @Test
    public void test4(){
        String name = jdbcTemplate.queryForObject("select name from account where id=?", String.class, 1);
        System.out.println(name); // 油条
    }

    // 查询总计
    @Test
    public void test5(){
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count); // 4
    }

    // 查询一整条记录
    @Test
    public void test6(){
        Account account = jdbcTemplate.queryForObject("select * from account where id=?", new MyRowMap(), 1);
        System.out.println(account); // Account{id=1, name='油条', money=666.0}
    }

    // 查询所有记录
    @Test
    public void test7(){
        List<Account> accountList = jdbcTemplate.query("select * from account", new MyRowMap());
        for (Account account : accountList) {
            System.out.println(account);
            /**
             * Account{id=1, name='油条', money=666.0}
             * Account{id=3, name='高星1', money=999.0}
             * Account{id=4, name='高星2', money=999.0}
             * Account{id=5, name='高星3', money=999.0}
             */
        }
    }
}

class MyRowMap implements RowMapper<Account>{

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getDouble("money"));
        return account;
    }
}
