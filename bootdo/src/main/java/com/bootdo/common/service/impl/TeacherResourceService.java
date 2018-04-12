package com.bootdo.common.service.impl;

import com.bootdo.common.dao.TeacherResourceDAO;
import com.bootdo.common.domain.FileDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/4/12 17:29
 */
@Service
public class TeacherResourceService {
    private Logger logger = LoggerFactory.getLogger(TeacherResourceService.class);
    @Autowired
    private TeacherResourceDAO trd;

    public List<FileDO> listFile(Map<String, Object> map) {
        logger.info("TeacherResourceService.listFile|map = {}",map.toString());
        return trd.listFile(map);
    }

    public Integer countTotal(Map<String, Object> map) {
        logger.info("TeacherResourceService.countTotal|map = {}",map.toString());
        return trd.countTotal(map);
    }
}
