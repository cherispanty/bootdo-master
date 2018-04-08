package com.bootdo.common.dao;

import com.bootdo.common.domain.FileDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/4/8 19:51
 */
@Mapper
public interface SysDocumentDao {
    List<FileDO> listAllFile(Map<String, Object> map);
    Integer countTotal(Map<String, Object> map);
    //批量删除文档
    Integer batchRemove(Long[] ids);
}
