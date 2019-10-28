package com.gaoxing.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    public static final SqlSessionFactory sessionFactory;
    static {
        // 1.SqlSessionFactoryBuilder加载配置文件
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 2.读取配置文件
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("SqlMappingConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3.获取session工厂
        sessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
    }

    public static SqlSession opensession(){
        return sessionFactory.openSession();
    }


}
