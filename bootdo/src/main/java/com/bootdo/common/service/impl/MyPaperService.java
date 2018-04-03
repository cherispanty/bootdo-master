package com.bootdo.common.service.impl;

import com.bootdo.common.dao.MyPaperDao;
import com.bootdo.common.domain.PaperDO;
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

    //保存论文
    public Integer save(PaperDO paperDO){
        logger.info("MyPaperService.save|paperDO = {}",paperDO.toString());
        Integer rows = myPaperDao.save(paperDO);
        return rows;
    }

    //获得指导老师id
    public Long queryMyteacherId(Long studentId) {
        logger.info("MyPaperService.save|studentId = {}",studentId);
        return myPaperDao.queryMyTeacherId(studentId);
    }

    //查看论文明细
    public PaperDO queryPaperDetail(Long id) {
        logger.info("MyPaperService.queryPaperDetail|id = {}",id);
        return myPaperDao.queryPaperDetail(id);
    }

    //撤销上传的论文
    public Integer cancelPaper(Long id) {
        logger.info("MyPaperService.cancelPaper|id = {}",id);
        return myPaperDao.cancelPaper(id);
    }

    //删除上传的论文
    public Integer removePaper(Long id) {
        logger.info("MyPaperService.removePaper|id = {}",id);
        return myPaperDao.removePaper(id);
    }
}
