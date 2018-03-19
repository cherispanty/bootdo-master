package com.bootdo.common.service.impl;

import com.bootdo.system.domain.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
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
    @Autowired
    private SelectTeacherServiceImpl selectTeacherService;
    @Test
    public void queryTeacherList() throws Exception {
        Map<String, Object> map = new HashMap<>();
//        map.put("userId",6);
        List<UserDO> userDOList = selectTeacherService.queryTeacherList(map);
        System.out.println(userDOList);
    }

}