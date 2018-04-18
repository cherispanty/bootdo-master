package com.bootdo.common.service.impl;

import com.bootdo.common.domain.FileDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Linchong
 * @date 2018/4/18 14:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyDocumentServiceImplTest {
    @Autowired
    private MyDocumentServiceImpl msdi;
    private Logger logger = LoggerFactory.getLogger(MyDocumentServiceImplTest.class);
    @Test
    public void get() {
        FileDO fileDO = msdi.get(32L);
        logger.info("fileDO = {}",fileDO.toString());
    }
}