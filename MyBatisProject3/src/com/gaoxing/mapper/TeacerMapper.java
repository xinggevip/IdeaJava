package com.gaoxing.mapper;

import com.gaoxing.domain.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacerMapper {
    public List<Teacher> getTeachers();
    public Teacher getTeacherWidthId(Integer id);
    /* 保存老师 */
    public void insertTeacher(Teacher teacher);
    /* 插入关系记录 */
    public void insertRelation(@Param("stu_id") Integer stu_id, @Param("teacher_id") Integer teacher_id);

}
