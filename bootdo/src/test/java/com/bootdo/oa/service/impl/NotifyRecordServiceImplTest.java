package com.bootdo.oa.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

/**
 * @author Linchong
 * @date 2018/4/13 11:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NotifyRecordServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(NotifyRecordServiceImplTest.class);
    @Autowired
    private NotifyRecordServiceImpl nrsi;
    @Test
    public void batchRead() {
        Map<String, Object> map = new HashMap<>();
        List<Long> list = new ArrayList<>();
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        System.out.println(dateFormat.format(date));
        list.add(53L);
        list.add(54L);
        map.put("readDate",dateFormat.format(date));
        map.put("list",list);
        map.put("userId",141);
        logger.info("map = {}",map.toString());
        int i = nrsi.batchRead(map);
        logger.info("i = {}",i);

//        Long[] ids = {53L,54L};
//        logger.info("ids  = {}",ids.toString());
//        int i = nrsi.batchRead(ids);
//        logger.info("i = {}",i);


    }
}