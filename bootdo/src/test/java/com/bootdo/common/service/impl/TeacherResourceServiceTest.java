package com.bootdo.common.service.impl;

import com.bootdo.common.domain.FileDO;
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
 * @date 2018/4/12 17:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherResourceServiceTest {
    private Logger logger = LoggerFactory.getLogger(TeacherResourceServiceTest.class);
    @Autowired
    private TeacherResourceService trs;
    @Test
    public void listFile() {
        Map<String, Object> map = new HashMap<>();
        map.put("studentId",141);
        List<FileDO> fileList = trs.listFile(map);
        logger.info("list = {}",fileList.toString());
    }

    @Test
    public void countTotal() {
        Map<String, Object> map = new HashMap<>();
        map.put("studentId",141);
        Integer total = trs.countTotal(map);
        logger.info("total = {}",total);
    }
}