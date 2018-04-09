package com.bootdo.common.service.impl;

import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.utils.ShiroUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Linchong
 * @date 2018/3/27 17:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyApplyServiceTest {
    private Logger logger = LoggerFactory.getLogger(MyApplyServiceTest.class);
    @Autowired
    private MyApplyService myApplyService;
    @Test
    public void queryMyApply() {
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", 1);
        map.put("offset",0);
        map.put("limit",10);
        List<TeacherStudent> teacherStudentList = myApplyService.queryMyApply(map);
        logger.info("teacherStudentList = {}",teacherStudentList.toString());
    }

    @Test
    public void countTotal() {
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", 1);
        map.put("offset",0);
        map.put("limit",10);
        Integer total = myApplyService.countTotal(map);
        logger.info("total = {}",total);
    }

    @Test
    public void test() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
//        return sdf.format(date);
        logger.info("year = {}",sdf.format(date));
    }
}