package com.gaoxing.mapper;

import com.gaoxing.domain.Teacher;
import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teacherId);

    int insert(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherId);

    List<Teacher> selectAll();

    int updateByPrimaryKey(Teacher record);
}