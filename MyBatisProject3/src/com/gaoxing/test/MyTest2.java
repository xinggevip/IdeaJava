package com.gaoxing.test;

import com.gaoxing.domain.Student;
import com.gaoxing.domain.Teacher;
import com.gaoxing.mapper.StudentMapper;
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

    @Test
    public void getStuByTeacher(){
        SqlSession sqlSession = MybatisUtils.opensession();
        TeacerMapper teacerMapper = sqlSession.getMapper(TeacerMapper.class);

        Teacher teacherWidthId = teacerMapper.getTeacherWidthId(1);
        System.out.println(teacherWidthId);

        sqlSession.close();
    }
    
    @Test
    public void saveBoth(){
        SqlSession sqlSession = MybatisUtils.opensession();
        TeacerMapper teacerMapper = sqlSession.getMapper(TeacerMapper.class);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Teacher teacher1 = new Teacher();
        teacher1.setTeacher_name("苍老师");

        Student student1 = new Student();
        student1.setStu_name("学生1");
        Student student2 = new Student();
        student2.setStu_name("学生2");

        teacher1.getStudents().add(student1);
        teacher1.getStudents().add(student2);

        // 插入老师
        teacerMapper.insertTeacher(teacher1);
        // 插入学生
        studentMapper.insertStudent(student1);
        studentMapper.insertStudent(student2);
        // 插入多对多关系
        for (Student student : teacher1.getStudents()) {
            teacerMapper.insertRelation(student.getStu_id(),teacher1.getTeacher_id());
        }

        sqlSession.commit();
        sqlSession.close();

    }
}
