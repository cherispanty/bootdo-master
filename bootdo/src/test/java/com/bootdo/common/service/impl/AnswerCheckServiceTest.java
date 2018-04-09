package com.bootdo.common.service.impl;

import com.bootdo.common.dto.PaperDTO;
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
 * @date 2018/4/9 15:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerCheckServiceTest {
    @Autowired
    private AnswerCheckService acs;
    private Logger logger = LoggerFactory.getLogger(AnswerCheckServiceTest.class);
    @Test
    public void listPaper() {
        Map<String, Object> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String year = sdf.format(date);
        map.put("createTime",year);
        List<PaperDTO> paperList = acs.listPaper(map);
        logger.info("paperList = {}",paperList.toString());
    }
}