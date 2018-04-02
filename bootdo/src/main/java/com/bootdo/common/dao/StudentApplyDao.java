package com.bootdo.common.dao;

import com.bootdo.common.dto.TeacherStudent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/3/27 15:29
 */
@Mapper
public interface StudentApplyDao {
    /**
     * 查看老师学生的绑定关系（type = 0表示学生的申请，type = 1表示老师的邀请）
     * @param map
     * @return
     */
    List<TeacherStudent> queryTeacherStudent(Map<String, Object> map);

    /**
     * 统计记录的条数，用于分页
     * @param map
     * @return
     */
    Integer countTotal(Map<String, Object> map);

    /**
     * 更新老师-学生关联状态
     * @param teacherStudent
     * @return
     */
    Integer updateLinkStatus(TeacherStudent teacherStudent);

    /**
     * 修改学生拥有导师的状态（同意：has_teacher=1,解绑：has_teacher=0）
     * @param map
     * @return
     */
    Integer updateHasTeacher(Map<String, Object> map);

    /**
     * 将该学生的其他申请的待查看状态都设置为失效状态（在执行同意该学生申请后执行该操作）
     * @param studentId
     * @return
     */
    Integer updateOtherLinkStatus(long studentId);
}
