package com.bootdo.common.service.impl;

import com.bootdo.common.dao.SelectTeacherDao;
import com.bootdo.common.dto.TeacherDTO;
import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.service.SelectTeacherService;
import com.bootdo.common.utils.ConstantVal;
import com.bootdo.common.utils.ShiroUtils;
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

    /**
     * 根据userId查询老师信息
     *
     * @param userId
     * @return
     */
    @Override
    public TeacherDTO queryTeacherByUserId(Long userId) {
        logger.info("SelectTeacherServiceImpl.queryTeacherByUserId()| userId = {}",userId);
        return selectTeacherDao.queryTeacherByUserId(userId);
    }

    /**
     * 添加一条学生-老师关联记录
     *
     * @param teacherStudent
     * @return
     */
    @Override
    public Integer saveTeacherStudent(TeacherStudent teacherStudent) {
        logger.info("SelectTeacherServiceImpl.saveApplyRecord()|begin teacherStudent = {}",teacherStudent.toString());
        teacherStudent.setLinkStatus(ConstantVal.LINK_STATUS_APPLY);
        logger.info("SelectTeacherServiceImpl.saveApplyRecord()|after teacherStudent = {}",teacherStudent.toString());
        return selectTeacherDao.insertTeacherStudent(teacherStudent);
    }

    @Override
    public List<TeacherStudent> queryRecordBySidAndTid(Map<String, Object> map) {
        logger.info("SelectTeacherServiceImpl.queryRecordBySidAndTid()|map = {}",map.toString());
        return selectTeacherDao.queryRecordBySidAndTid(map);
    }
}
