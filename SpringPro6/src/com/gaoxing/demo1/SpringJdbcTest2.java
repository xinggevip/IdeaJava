package com.gaoxing.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

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
}
