package com.bootdo.common.service.impl;

import com.bootdo.common.dao.MyPaperDao;
import com.bootdo.common.dto.PaperDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/4/3 10:45
 */
@Service
public class MyPaperService {
    private Logger logger = LoggerFactory.getLogger(MyPaperService.class);
    @Autowired
    private MyPaperDao myPaperDao;

    public List<PaperDTO> list(Map<String, Object> map) {
        logger.info("MyPaperService.list|map = {}",map.toString());
        List<PaperDTO> list = myPaperDao.list(map);
        if(list != null && list.size() > 0) {
            logger.info("MyPaperService.list|list = {}",list.toString());
            return list;
        }
        logger.info("MyPaperService.list|list = {}",list);
        return list;
    }

    public Integer countTotal(Map<String, Object> map) {
        logger.info("MyPaperService.countTotal|map = {}",map.toString());
        Integer total = myPaperDao.countTotal(map);
        logger.info("MyPaperService.countTotal|total = {}",total);
        return total;
    }
}
