package com.bootdo.common.service.impl;

import com.bootdo.common.dao.StudentPaperDao;
import com.bootdo.common.dto.PaperDTO;
import com.bootdo.common.dto.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/4/8 14:10
 */
@Service
public class StudentPaperService {
    @Autowired
    private StudentPaperDao spd;
    private Logger logger = LoggerFactory.getLogger(StudentPaperService.class);


    public List<PaperDTO>  listPaper(Map<String, Object> map) {
        logger.info("StudentPaperService.listPaper|map = {}",map.toString());
        return spd.listPaper(map);
    }

    public Integer countTotal(Map<String, Object> map) {
        logger.info("StudentPaperService.countTotal|map = {}",map.toString());
        return spd.countTotal(map);
    }
}
