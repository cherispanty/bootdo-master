package com.bootdo.common.service.impl;

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
 * @date 2018/3/28 21:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectStudentServiceTest {
    private Logger logger = LoggerFactory.getLogger(SelectStudentServiceTest.class);
    @Autowired
    private SelectStudentService sss;
    @Test
    public void queryStudentList() {
        Map<String,Object> map = new HashMap<>();
//        map.put("")
//        map.put("name","林");
//        map.put("offset",0);
//        map.put("limit",10);
        map.put("className","14");
        List<StudentDTO> studentDTOList = sss.queryStudentList(map);
        logger.info("queryStudentList｜studentDTOList = {}",studentDTOList.toString());
    }

    @Test
    public void countTotalTest() {
        Map<String,Object> map = new HashMap<>();
//        map.put("")
//        map.put("name","林");
//        map.put("offset",0);
//        map.put("limit",10);
//        map.put("className","14");
        Integer total = sss.countTotal(map);
        logger.info("queryStudentList｜total = {}",total);
    }
}