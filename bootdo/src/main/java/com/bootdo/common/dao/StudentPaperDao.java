package com.bootdo.common.dao;

import com.bootdo.common.dto.PaperDTO;
import com.bootdo.common.dto.StudentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/4/8 14:03
 */
@Mapper
public interface StudentPaperDao {
    //查询我的学生的论文
    List<PaperDTO> listPaper(Map<String, Object> map);
    Integer countTotal(Map<String, Object> map);
}
