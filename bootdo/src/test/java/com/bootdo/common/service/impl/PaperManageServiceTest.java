package com.bootdo.common.service.impl;

import com.bootdo.common.dto.PaperDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Linchong
 * @date 2018/4/9 10:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaperManageServiceTest {
    private Logger logger = LoggerFactory.getLogger(PaperManageServiceTest.class);
    @Autowired
    private PaperManageService pms;
    @Test
    public void listPaper() {
        Map<String, Object> map = new HashMap<>();
        map.put("deptId",38);
        List<PaperDTO> paperList = pms.listPaper(map);
        logger.info("list = {}",paperList.toString());
    }

    @Test
    public void countTotalTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("deptId",38);
        Integer total = pms.countTotal(map);
        logger.info("total = {}",total);
    }
}