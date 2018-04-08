package com.bootdo.common.controller;

import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.service.impl.MyApplyService;
import com.bootdo.common.service.impl.StudentApplyService;
import com.bootdo.common.service.impl.TeacherInviteService;
import com.bootdo.common.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/3/27 15:21
 */
@Controller
@RequestMapping("/common/teacherInvite")
public class TeacherInviteController {
    private Logger logger = LoggerFactory.getLogger(TeacherInviteController.class);
    @Autowired
    private TeacherInviteService tis;

    @GetMapping()
    public String teacherInvite() {
        return "common/teacherInvite/teacherInvite";
    }

    /**
     * 查询老师的邀请
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/list")
    public PageUtils list(@RequestParam Map<String, Object> params) throws Exception {
        logger.info("TeacherInviteController.list()|params = {}",params.toString());
        params.put("studentId", ShiroUtils.getUserId());
        //只查询老师的邀请，筛选掉学生的邀请(type = 1)
        params.put("type",ConstantVal.TEACHER_TYPE_INVITE);
        logger.info("TeacherInviteController.list()|params = {}",params.toString());
        Query query = new Query(params);
        try{
            //查询老师邀请记录
            List<TeacherStudent> teacherStudentList = tis.list(query);
            if(teacherStudentList != null && teacherStudentList.size() > 0){
                String studentName = ShiroUtils.getUser().getName();
                //添加学生信息
                for (TeacherStudent ts:
                        teacherStudentList) {
                    ts.setStudentName(studentName);
                }
            }
            //查询老师的邀请记录条数
            Integer total = tis.countTotal(query);
            PageUtils pageUtils = new PageUtils(teacherStudentList,total);
            logger.info("TeacherInviteController.list()|pageUtils = {}",pageUtils.toString());
            return pageUtils;
        }catch (BDException e) {
            logger.info("TeacherInviteController.list()|查询失败 原因 = {}",e.getMessage());
            throw e;
        }catch (Exception e){
            logger.info("TeacherInviteController.list()|查询失败",e);
            throw e;
        }
    }


    /**
     * 同意该老师的邀请
     * @param id
     * @return
     */
    @PostMapping("/agree")
    @ResponseBody
    public R agree(Long id) {
        logger.info("TeacherInviteController.agree|id = {}",id);
        //通过id查询该邀请记录
        TeacherStudent teacherStudent = tis.queryTeacherStudentById(id);
        if(teacherStudent == null) {
            logger.info("TeacherInviteController.agree|teacherStudent = {}",teacherStudent);
            return R.error("操作失败，该记录不存在");
        }
        //修改link_status状态为同意状态
        teacherStudent.setLinkStatus(ConstantVal.LINK_STATUS_CONN);
        Integer rows = tis.updateLinkStatus(teacherStudent);
        //修改该学生的是否有导师的状态（hasTeacher = 1）
        Map<String, Object> map = new HashMap<>();
        map.put("studentId",ShiroUtils.getUserId());
        map.put("hasTeacher",ConstantVal.STUDENT_HAS_TEACHER);
        tis.updateHasTeacher(map);
        if(rows > 0) {
            logger.info("MyApplyController.agree|操作成功");
            return R.ok();
        }
        return R.error("操作失败");
    }

    /**
     * 同意该老师的邀请
     * @param id
     * @return
     */
    @PostMapping("/disagree")
    @ResponseBody
    public R disagree(Long id) {
        logger.info("TeacherInviteController.agree|id = {}",id);
        //通过id查询该邀请记录
        TeacherStudent teacherStudent = tis.queryTeacherStudentById(id);
        if(teacherStudent == null) {
            logger.info("TeacherInviteController.agree|teacherStudent = {}",teacherStudent);
            return R.error("操作失败，该记录不存在");
        }
        //修改link_status状态为拒绝状态
        teacherStudent.setLinkStatus(ConstantVal.LINK_STATUS_REFUSE);
        Integer rows = tis.updateLinkStatus(teacherStudent);
        if(rows > 0) {
            logger.info("MyApplyController.agree|操作成功");
            return R.ok();
        }
        return R.error("操作失败");
    }



}
