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
     * 查询申请记录
     * @param map
     * @return
     */
    List<TeacherStudent> queryTeacherStudent(Map<String, Object> map);
}
