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
}
