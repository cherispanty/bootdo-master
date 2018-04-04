package com.bootdo.common.service.impl;

import com.bootdo.common.dao.StudentDocumentDao;
import com.bootdo.common.domain.FileDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/4/4 11:19
 */
@Service
public class StudentDocumentService {
    private Logger logger = LoggerFactory.getLogger(StudentDocumentService.class);
    @Autowired
    private StudentDocumentDao sdd;

    /**
     * 查看我的学生上传的文档
     * @param map
     * @return
     */
    public List<FileDO> list(Map<String, Object> map) {
        logger.info("StudentDocumentService.list|map = {}",map.toString());
        List<FileDO> list = sdd.list(map);
        logger.info("StudentDocumentService.list|list = {}",list.toString());
        return list;
    }

    public Integer countTotal(Map<String, Object> map) {
        logger.info("StudentDocumentService.countTotal|map = {}",map.toString());
        Integer total = sdd.countTotal(map);
        return total;
    }

    //评论学生文档
    public Integer updateComment(Map<String, Object> map) {
        logger.info("StudentDocumentService.updateComment|map = {}",map.toString());
        return sdd.updateComment(map);
    }
    //查询学生上传的文档信息
    public FileDO queryFileById(Long id) {
        logger.info("StudentDocumentService.queryFileById|id = {}",id);
        return sdd.queryFileById(id);
    }
}
