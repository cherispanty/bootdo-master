package com.bootdo.common.service.impl;

import com.bootdo.common.dto.TeacherDTO;
import com.bootdo.system.domain.UserDO;
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
 * Created by Linchong on 2018/3/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTeacherServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(SelectTeacherServiceImplTest.class);
    @Autowired
    private SelectTeacherServiceImpl selectTeacherService;
    @Test
    public void queryTeacherList() throws Exception {
        Map<String, Object> map = new HashMap<>();
//        map.put("userId",6);
        List<TeacherDTO> dtoList = selectTeacherService.queryTeacherList(map);
        logger.info("dtoList = {}",dtoList.toString());
    }

    @Test
    public void countTest() {
        int count = selectTeacherService.count(new HashMap<>());
        logger.info("count = {}",count);
    }

}