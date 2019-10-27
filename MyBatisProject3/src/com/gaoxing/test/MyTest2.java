package com.gaoxing.test;

import com.gaoxing.domain.Teacher;
import com.gaoxing.mapper.TeacerMapper;
import com.gaoxing.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest2 {
    @Test
    public void getTeachers(){
        SqlSession sqlSession = MybatisUtils.opensession();
        TeacerMapper teacerMapper = sqlSession.getMapper(TeacerMapper.class);

        List<Teacher> teachers = teacerMapper.getTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }

        sqlSession.close();
    }
}
