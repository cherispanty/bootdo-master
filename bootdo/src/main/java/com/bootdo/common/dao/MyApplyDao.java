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
public interface MyApplyDao {
    /**
     * 所有申请记录条数
     * @return
     */
    Integer countTotal(Map<String, Object> map);

    /**
     * 查询申请记录（我的申请）
     * @param map
     * @return
     */
    List<TeacherStudent> queryTeacherStudent(Map<String, Object> map);

    /**
     * 通过id查询申请记录
     * @param id
     * @return
     */
    TeacherStudent queryTeacherStudentById(Long id);

    /**
     * 更新老师-学生连接状态
     * @param ts
     * @return
     */
    Integer updateTeacherStudent(TeacherStudent ts);
}
