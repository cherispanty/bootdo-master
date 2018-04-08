package com.bootdo.common.dao;

import com.bootdo.common.domain.FileDO;
import com.bootdo.common.dto.StudentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/4/4 10:50
 */
@Mapper
public interface StudentDocumentDao {
    //查看所有学生的文档
    List<FileDO> list(Map<String, Object> map);
    Integer countTotal(Map<String, Object> map);
    //老师评论文档,同时将文档状态设置为"已评阅"
    Integer updateComment(Map<String, Object> map);
    //通过id查询学生上传单个文件的记录
    FileDO queryFileById(Long id);
    //查询我的学生
    List<StudentDTO> queryStudentList(Long teacherId);
}
