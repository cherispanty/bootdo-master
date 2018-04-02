package com.bootdo.common.service.impl;

import com.bootdo.common.dao.MyStudentListDao;
import com.bootdo.common.dto.StudentDTO;
import com.bootdo.common.dto.TeacherStudent;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/3/30 11:26
 */
@Service
public class MyStudentListService {
    private Logger logger = LoggerFactory.getLogger(MyStudentListService.class);
    @Autowired
    private MyStudentListDao msld;

    /**
     * 查询我的学生的id和论文题目
     * @param map
     * @return
     */
    public List<TeacherStudent> querySidAndPt(Map<String, Object> map) {
        logger.info("MyStudentListService.querySidAndPt()|map = {}",map.toString());
        List<TeacherStudent> tsList = msld.querySidAndPt(map);
        logger.info("MyStudentListService.querySidAndPt()|tsList = {}",tsList.toString());
        return tsList;
    }

    public Integer countTotal(Map<String, Object> map) {
        logger.info("MyStudentListService.countTotal|map = {}",map.toString());
        Integer total = msld.countTotal(map);
        logger.info("MyStudentListService.countTotal|total = {}",total);
        return total;
    }

    /**
     * 通过id查询学生信息
     * @param studentId
     * @return
     */
    public StudentDTO queryStudent(Long studentId){
        logger.info("MyStudentListService.queryStudent|studentId = {}",studentId);
        StudentDTO studentDTO = msld.queryStudent(studentId);
        logger.info("MyStudentListService.queryStudent|studentDTO = {}",studentDTO.toString());
        return studentDTO;
    }


    /**
     * 录入或修改论文题目
     * @param teacherStudent
     * @return
     */
    public Integer updatePaperTile(TeacherStudent teacherStudent) {
        logger.info("MyStudentListService.updatePaperTile|teacherStudent = {}",teacherStudent.toString());
        return msld.updatePaperTitle(teacherStudent);
    }

    /**
     * 解除老师-学生之间的导师学生关系
     * @param map
     * @return
     */
    public Integer dismissTeacherAndStudent(Map<String, Object> map) {
        logger.info("MyStudentListService.dismissTeacherAndStudent|map = {}",map.toString());
        return msld.updateLinkStatus(map);
    }

    /**
     * 将学生设置为无导师状态（执行解绑操作的后续动作）
     * @param studentId
     * @return
     */
    public Integer updateHasTeacher(Long studentId) {
        logger.info("MyStudentListService.updateHasTeacher|studentId = {}",studentId);
        return msld.updateHasTeacher(studentId);
    }
}
