package com.bootdo.common.service.impl;

import com.bootdo.common.dao.PaperManagerDao;
import com.bootdo.common.dto.PaperDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/4/9 10:33
 */
@Service
public class PaperManageService {
    @Autowired
    private PaperManagerDao pmd;
    private Logger logger = LoggerFactory.getLogger(PaperManageService.class);

    public List<PaperDTO> listPaper(Map<String, Object> map) {
        logger.info("PaperManageService.listPaper|map = {}",map.toString());
        return pmd.listPaper(map);
    }

    public Integer countTotal(Map<String, Object> map) {
        logger.info("PaperManageService.countTotal|map = {}",map.toString());
        return pmd.countTotal(map);
    }

    public PaperDTO findPaperById(Long id) {
        logger.info("PaperManageService.findPaperById|id = {}",id);
        return pmd.queryPaperById(id);
    }

    public Integer savePaperDetail(PaperDTO paperDTO) {
        logger.info("PaperManageService.savePaperDetail|paperDTO = {}",paperDTO.toString());
        return pmd.savePaperDetail(paperDTO);
    }
}
