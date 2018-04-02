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
    //通过studentId和TeahcerId查询申请（邀请）记录
    List<TeacherStudent> queryRecordBySidAndTid(Map<String, Object> map);
    //添加一条学生-老师关联记录
    Integer insertTeacherStudent(TeacherStudent teacherStudent);
    //查询老师已带(已申请)学生
    Integer queryKindsOfNum(Map<String, Object> map);
    //查询该学生有几个导师（num > 0有了导师，不能再申请）
    Integer queryByStudentId(Long studentId);
}
