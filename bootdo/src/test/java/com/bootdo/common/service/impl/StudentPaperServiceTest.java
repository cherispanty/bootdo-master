package com.bootdo.common.service.impl;

import com.bootdo.common.dto.PaperDTO;
import com.bootdo.common.dto.StudentDTO;
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
 * @date 2018/4/8 14:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentPaperServiceTest {
    private Logger logger = LoggerFactory.getLogger(StudentPaperServiceTest.class);
    @Autowired
    private StudentPaperService sps;

    @Test
    public void listPaperTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("teacherId",123);
        List<PaperDTO> paperDTOS = sps.listPaper(map);
        logger.info("paperDTOS = {}",paperDTOS.toString());
    }
}