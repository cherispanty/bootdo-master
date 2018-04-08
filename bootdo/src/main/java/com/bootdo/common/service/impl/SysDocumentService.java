package com.bootdo.common.service.impl;

import com.bootdo.common.dao.SysDocumentDao;
import com.bootdo.common.domain.FileDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/4/8 19:58
 */
@Service
public class SysDocumentService {
    @Autowired
    private SysDocumentDao sdd;
    private Logger logger = LoggerFactory.getLogger(SysDocumentService.class);

    public List<FileDO> queryAllFile(Map<String, Object> map) {
        logger.info("SysDocumentService.queryAllFile|map = {}",map.toString());
        List<FileDO> fileList = sdd.listAllFile(map);
        return fileList;
    }

    public Integer countTotal(Map<String, Object> map) {
        logger.info("SysDocumentService.countTotal|map = {}",map.toString());
        Integer total = sdd.countTotal(map);
        return total;
    }

    public Integer batchRemove(Long[] ids) {
        logger.info("SysDocumentService.batchRemove|ids = {}",ids.toString());
        return sdd.batchRemove(ids);
    }

}
