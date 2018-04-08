package com.bootdo.common.dao;

import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.service.impl.TeacherInviteService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/3/27 15:29
 */
@Mapper
public interface TeacherInviteDao {
    /**
     * 查询“老师的邀请”
     * @param map
     * @return
     */
    List<TeacherStudent> list(Map<String, Object> map);

    /**
     * 查询“老师的邀请”记录条数
     * @param map
     * @return
     */
    Integer countTotal(Map<String, Object> map);

    TeacherStudent queryTeacherStudentById(Long id);

    Integer updateTeacherStudent(TeacherStudent teacherStudent);
    //修改我的“是否拥有导师”状态
    Integer updateHasTeacher(Map<String, Object> map);
}
