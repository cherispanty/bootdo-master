package com.bootdo.common.dao;

import com.bootdo.common.dto.TeacherDTO;
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
}
