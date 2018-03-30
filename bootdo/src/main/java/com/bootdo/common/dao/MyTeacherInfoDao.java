package com.bootdo.common.dao;

import com.bootdo.common.dto.TeacherDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Linchong
 * @date 2018/3/29 18:26
 */
@Mapper
public interface MyTeacherInfoDao {
    //查询我的老师id(存在多个id时逻辑上不允许，需要联系管理员处理)
    public List<Long> queryMyTeacherId(Long studentId);

    //通过id查询我的老师信息
    public TeacherDTO queryMyTeacherById(Long teacherId);
}
