package com.bootdo.common.service;

import com.bootdo.common.dto.TeacherDTO;
import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.system.domain.UserDO;

import java.util.List;
import java.util.Map;

/**
 * Created by Linchong on 2018/3/18.
 */
public interface SelectTeacherService {
    //查询老师信息
    List<TeacherDTO> queryTeacherList(Map<String, Object> map);
    //统计记录条数
    int count(Map<String, Object> map);

    /**
     * 根据userId查询老师信息
     * @param userId
     * @return
     */
    TeacherDTO queryTeacherByUserId(Long userId);

    /**
     * 添加老师-学生关联记录
     * @param teacherStudent
     * @return
     */
    Integer saveTeacherStudent(TeacherStudent teacherStudent);

    /**
     * 通过老师id和学生id查询记录
      * @param map
     * @return
     */
    List<TeacherStudent> queryRecordBySidAndTid(Map<String,Object> map);

    /**
     * 查询有关老师的各种数据（已带学生，申请学生）
     * @param map
     * @return
     */
    Integer findNumsOfTeacher(Map<String, Object> map);

    /**
     * 查询该学生已经有几个导师
     * @param studentId
     * @return
     */
    Integer queryByStudentId(Long studentId);
}
