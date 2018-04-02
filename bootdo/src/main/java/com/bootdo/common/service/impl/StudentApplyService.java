package com.bootdo.common.service.impl;

import com.bootdo.common.dao.MyApplyDao;
import com.bootdo.common.dao.StudentApplyDao;
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
public class StudentApplyService {
    private Logger logger = LoggerFactory.getLogger(StudentApplyService.class);
    @Autowired
    private StudentApplyDao studentApplyDao;

    /**
     * 查询老师-学生的绑定关系（type = 0表示学生的申请，type = 1表示老师的邀请）
     * @param map
     * @return
     */
    public List<TeacherStudent> list(Map<String, Object> map) {
        logger.info("StudentApplyService.list()|map = {}",map.toString());
        List<TeacherStudent> teacherStudentList = studentApplyDao.queryTeacherStudent(map);
        logger.info("StudentApplyService.list()|teacherStudentList = {}",teacherStudentList.toString());
        return teacherStudentList;
    }

    /**
     * 查询老师-学生的绑定关系记录条数
     * @param map
     * @return
     */
    public Integer countTotal(Map<String, Object> map) {
        logger.info("StudentApplyService.list()|map = {}",map.toString());
        Integer total = studentApplyDao.countTotal(map);
        logger.info("StudentApplyService.countTotal|total = {}",total);
        return total;
    }

    /**
     * 更新学生-老师连接状态
     * @param teacherStudent
     * @return
     */
    public Integer updateLinkStatus(TeacherStudent teacherStudent) {
        logger.info("StudentApplyService.updateLinkStatus()|map = {}",teacherStudent.toString());
        return studentApplyDao.updateLinkStatus(teacherStudent);
    }

    /**
     * 修改学生拥有导师的状态（同意：has_teacher=1,解绑：has_teacher=0）
     * @param map
     * @return
     */
    public Integer updateHasTeacher(Map<String, Object> map){
        logger.info("StudentApplyService.updateHasTeacher|map = {}",map.toString());
        return studentApplyDao.updateHasTeacher(map);
    }

    /**
     * 将该学生的其他申请都设置为失效状态
     * @return
     */
    public Integer clearOtherApply(Long studentId){
        logger.info("StudentApplyService.clearOtherApply|studentId = {}",studentId);
        return studentApplyDao.updateOtherLinkStatus(studentId);
    }

}
