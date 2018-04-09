package com.bootdo.common.service.impl;

import com.bootdo.common.dao.AnswerCheckDao;
import com.bootdo.common.dto.PaperDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/4/9 15:20
 */
@Service
public class AnswerCheckService {
    private Logger logger = LoggerFactory.getLogger(AnswerCheckService.class);
    @Autowired
    private AnswerCheckDao acd;

    public List<PaperDTO> listPaper(Map<String, Object> map) {
        logger.info("AnswerCheckService.listPaper|map = {}",map.toString());
        return acd.listPaper(map);
    }

    public Integer countTotal(Map<String, Object> map) {
        logger.info("AnswerCheckService.countTotal|map = {}",map.toString());
        return acd.countTotal(map);
    }

    public PaperDTO findPaperById(Long id) {
        logger.info("AnswerCheckService.findPaperById|id = {}",id);
        return acd.queryPaperById(id);
    }

    public Integer savePaper(PaperDTO paperDTO) {
        logger.info("AnswerCheckService.savePaper|paperDTO = {}",paperDTO.toString());
        return acd.savePaper(paperDTO);
    }
}
