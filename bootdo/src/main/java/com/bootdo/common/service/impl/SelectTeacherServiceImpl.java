package com.bootdo.common.service.impl;

import com.bootdo.common.dao.SelectTeacherDao;
import com.bootdo.common.dto.TeacherDTO;
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

    /**
     * 分页查询导师信息
     * @param map
     * @return
     */
    @Override
    public List<TeacherDTO> queryTeacherList(Map<String, Object> map) {
        logger.info("SelectTeacherServiceImpl.queryTeacherList()|map = {}",map.toString());
        List<TeacherDTO> dtoList = selectTeacherDao.queryTeacherList(map);
        return dtoList;
    }

    /**
     * 查询总的记录条数
     * @param map
     * @return
     */
    @Override
    public int count(Map<String, Object> map) {
        logger.info("SelectTeacherServiceImpl.count()| map = {}",map.toString());
        int count = selectTeacherDao.count(map);
        return count;
    }
}
