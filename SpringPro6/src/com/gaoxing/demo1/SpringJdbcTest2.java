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
    @Test
    public void test1(){
        jdbcTemplate.update("insert into account values (null,?,?)","高星",999d);
    }
}
