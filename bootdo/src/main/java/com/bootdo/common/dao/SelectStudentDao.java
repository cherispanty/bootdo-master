package com.bootdo.common.dao;

import com.bootdo.common.dto.DeptDTO;
import com.bootdo.common.dto.StudentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/3/27 18:05
 */
@Mapper
public interface SelectStudentDao {
    /**
     * 分页查询学生信息
     * @param map
     * @return
     */
    public List<StudentDTO> queryStudentList(Map<String, Object> map);

    /**
     * 查询记录条数便于分页
     * @param map
     * @return
     */
    public Integer countTotal(Map<String, Object> map);

    /**
     * 查询所有的班级信息
     * @return
     */
    public List<DeptDTO> queryDeptInfo();

    public StudentDTO queryStudentById(Long userId);
}
