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
 * @date 2018/4/4 11:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDocumentServiceTest {
    private Logger logger = LoggerFactory.getLogger(StudentDocumentServiceTest.class);
    @Autowired
    private StudentDocumentService sas;
    @Test
    public void list() {
        Map<String, Object> map = new HashMap<>();
        map.put("teacherId",123);
        List<FileDO> list = sas.list(map);
        logger.info("list = {}",list.toString());
    }

    @Test
    public void countTotal() {
    }

//    @Test
//    public void queryFileByIdTest() {
//        FileDO fileDO = sas.queryFileById(181L);
//        logger.info("fileDO = {}",fileDO.toString());
//    }
}