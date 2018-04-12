package com.bootdo.common.dao;

import com.bootdo.common.domain.FileDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/4/12 17:19
 */
@Mapper
public interface TeacherResourceDAO {
    List<FileDO> listFile(Map<String, Object> map);
    Integer countTotal(Map<String, Object> map);
}
