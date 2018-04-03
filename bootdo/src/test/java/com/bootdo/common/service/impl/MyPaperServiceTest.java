package com.bootdo.common.service.impl;

import com.bootdo.common.dao.MyPaperDao;
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
 * @date 2018/4/3 10:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyPaperServiceTest {
    private Logger logger = LoggerFactory.getLogger(MyPaperServiceTest.class);
    @Autowired
    private MyPaperDao paperDao;
    @Test
    public void list() {
        Map<String, Object> map = new HashMap<>();
        map.put("studentId",201401090124L);
        List<PaperDTO> list = paperDao.list(map);
        logger.info("list = {}",list.toString());
    }

    @Test
    public void countTotal() {
        Map<String, Object> map = new HashMap<>();
        map.put("studentId",201401090124L);
        Integer total = paperDao.countTotal(map);
        logger.info("total = {}",total);
    }
}