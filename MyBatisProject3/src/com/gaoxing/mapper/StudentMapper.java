package com.gaoxing.mapper;

import com.gaoxing.domain.Student;

import java.util.List;

public interface StudentMapper {
    public List<Student> getStuByTeacher(Integer id);
    /* 保存学生 */
    public void insertStudent(Student student);

}
