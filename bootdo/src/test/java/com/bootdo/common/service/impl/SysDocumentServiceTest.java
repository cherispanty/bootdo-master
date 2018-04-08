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
 * @date 2018/4/8 20:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysDocumentServiceTest {
    private Logger logger = LoggerFactory.getLogger(SysDocumentServiceTest.class);
    @Autowired
    private SysDocumentService sds;
    @Test
    public void queryAllFile() {
        Map<String, Object> map = new HashMap<>();
        map.put("userId",201401090124L);
        List<FileDO> fileList = sds.queryAllFile(map);
        logger.info("fileList = {}",fileList.toString());
    }
}