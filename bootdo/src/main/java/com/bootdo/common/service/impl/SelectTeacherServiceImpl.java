package com.bootdo.common.service.impl;

import com.bootdo.common.dao.SelectTeacherDao;
import com.bootdo.common.service.SelectTeacherService;
import com.bootdo.system.domain.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Linchong on 2018/3/18.
 */
@Service
public class SelectTeacherServiceImpl implements SelectTeacherService {
    private Logger logger = LoggerFactory.getLogger(SelectTeacherServiceImpl.class);
    @Autowired
    private SelectTeacherDao selectTeacherDao;
    @Override
    public List<UserDO> queryTeacherList(Map<String, Object> map) {
        List<UserDO> teacherList = selectTeacherDao.queryTeacherList(map);
        return teacherList;
    }
}
