package com.bootdo.common.dao;

import com.bootdo.common.dto.StudentDTO;
import com.bootdo.common.dto.TeacherStudent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/3/27 15:29
 */
@Mapper
public interface MyStudentListDao {
    //查询出我的学生的id和论文题目
    public List<TeacherStudent> querySidAndPt(Map<String, Object> map);
    //根据id查询我的学生信息
    public StudentDTO queryStudent(Long studentId);
    //统计我的学生人数
    public Integer countTotal(Map<String, Object> map);
    //录入论文题目
    public Integer updatePaperTitle(TeacherStudent teacherStudent);
    //解除老师-学生的导师学生关系
    public Integer updateLinkStatus(Map<String, Object> map);
}
