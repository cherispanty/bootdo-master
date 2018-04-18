package com.bootdo.common.service.impl;

import com.bootdo.common.dao.MyTeacherInfoDao;
import com.bootdo.common.domain.TeacherStudentDO;
import com.bootdo.common.dto.TeacherDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Linchong
 * @date 2018/3/29 18:26
 */
@Service
public class MyTeacherInfoService {
    private Logger logger = LoggerFactory.getLogger(MyTeacherInfoService.class);
    @Autowired
    private MyTeacherInfoDao myTeacherInfoDao;

    /**
     * 查询我的老师Id(存在多个ID时，出现逻辑错误，每个学生只能有一个论文导师)
     * @param studentId
     * @return
     */
    public List<TeacherStudentDO> queryMyTeacherId(Long studentId) {
        logger.info("MyTeacherInfoService.queryMyTeacherId()|studentId = {}",studentId);
        return myTeacherInfoDao.queryMyTeacherId(studentId);
    }

    /**
     * 查询我的论文导师信息
     * @param teacherId
     * @return
     */
    public TeacherDTO queryMyTeacherByTeacherId(Long teacherId) {
        logger.info("MyTeacherInfoService.queryMyTeacherByTeacher|teacherId = {}",teacherId);
        return myTeacherInfoDao.queryMyTeacherById(teacherId);
    }
}
