package com.bootdo.common.service.impl;

import com.bootdo.common.dto.TeacherStudent;
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
 * @date 2018/3/28 14:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentApplyServiceTest {
    private Logger logger = LoggerFactory.getLogger(StudentApplyServiceTest.class);
    @Autowired
    private StudentApplyService studentApplyService;
    @Test
    public void list() {
        Map<String, Object> map = new HashMap<>();
        map.put("teacherId",123);
        map.put("offset",0);
        map.put("limit",10);
        List<TeacherStudent> list = studentApplyService.list(map);
        logger.info("list = {}",list.toString());
    }

    @Test
    public void countTotal() {
        Map<String, Object> map = new HashMap<>();
        map.put("teacherId",123);
        map.put("offset",0);
        map.put("limit",10);
        Integer integer = studentApplyService.countTotal(map);
        logger.info("integer = {}",integer);
    }
}