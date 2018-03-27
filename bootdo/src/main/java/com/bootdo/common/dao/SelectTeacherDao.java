package com.bootdo.common.dao;

import com.bootdo.common.dto.TeacherDTO;
import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.system.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Linchong on 2018/3/18.
 */
@Mapper
public interface SelectTeacherDao {
    //查询老师列表
    List<TeacherDTO> queryTeacherList(Map<String, Object> map);
    //统计记录条数
    int count(Map<String, Object> map);
    //根据userId查询老师信息
    TeacherDTO queryTeacherByUserId(Long userId);

    /**
     * 保存一条学生申请记录
     * @param teacherStudent
     * @return
     */
    Integer insertTeacherStudent(TeacherStudent teacherStudent);
}
