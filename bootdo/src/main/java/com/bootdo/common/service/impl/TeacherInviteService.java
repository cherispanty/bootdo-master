package com.bootdo.common.service.impl;

import com.bootdo.common.dao.MyApplyDao;
import com.bootdo.common.dao.TeacherInviteDao;
import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.utils.BDException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/3/27 15:30
 */
@Service
public class TeacherInviteService {
    private Logger logger = LoggerFactory.getLogger(TeacherInviteService.class);
    @Autowired
    private TeacherInviteDao tid;

    /**
     * 查询老师的邀请记录
     * @param map
     * @return
     */
    public List<TeacherStudent> list(Map<String, Object> map) {
        logger.info("TeacherInviteService.list｜map = {}",map.toString());
        List<TeacherStudent> teacherStudentList = tid.list(map);
        return teacherStudentList;
    }

    /**
     * 查询老师邀请记录的条数
     * @param map
     * @return
     */
    public Integer countTotal(Map<String, Object> map) {
        logger.info("TeacherInviteService.countTotal|map = {}",map.toString());
        return tid.countTotal(map);
    }

    public TeacherStudent queryTeacherStudentById(Long id) {
        logger.info("TeacherInviteService.queryTeacherStudentById|id = {}",id);
        return tid.queryTeacherStudentById(id);
    }

    public Integer updateLinkStatus(TeacherStudent teacherStudent) {
        logger.info("TeacherInviteService.updateLinkStatus|teacherStudent = {}",teacherStudent.toString());
        return tid.updateTeacherStudent(teacherStudent);
    }
}
