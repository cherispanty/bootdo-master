package com.bootdo.common.controller;

import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.service.impl.MyApplyService;
import com.bootdo.common.service.impl.StudentApplyService;
import com.bootdo.common.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/3/27 15:21
 */
@Controller
@RequestMapping("/common/myInvite")
public class MyInviteController {
    private Logger logger = LoggerFactory.getLogger(MyInviteController.class);
    @Autowired
    private StudentApplyService studentApplyService;
    @Autowired
    private MyApplyService myApplyService;
    @GetMapping()
    public String myInvite() {
        return "common/myInvite/myInvite";
    }

    /**
     * 老师查看“我的邀请”
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/list")
    public PageUtils list(@RequestParam Map<String, Object> params) throws Exception {
        logger.info("MyInviteController.list()|params = {}",params.toString());
        params.put("teacherId", ShiroUtils.getUserId());
        //只查找我的邀请，筛选掉学生的申请
        params.put("type", ConstantVal.TEACHER_TYPE_INVITE);
        logger.info("MyInviteController.list()|params = {}",params.toString());
        Query query = new Query(params);
        try{
            //查询当前筛选条件下的我的申请记录
            List<TeacherStudent> teacherStudentList = studentApplyService.list(params);
            if(teacherStudentList != null && teacherStudentList.size() > 0){
                String teacherName = ShiroUtils.getUser().getName();
                //添加老师信息
                for (TeacherStudent ts:
                        teacherStudentList) {
                    ts.setTeacherName(teacherName);
                }
            }
            //查询符合条件的学生申请记录条数
            Integer total = studentApplyService.countTotal(query);
            PageUtils pageUtils = new PageUtils(teacherStudentList,total);
            logger.info("MyInviteController.list()|pageUtils = {}",pageUtils.toString());
            return pageUtils;
        }catch (BDException e) {
            logger.info("MyInviteController.list()|查询失败 原因 = {}",e.getMessage());
            throw e;
        }catch (Exception e){
            logger.info("MyInviteController.list()|查询失败",e);
            throw e;
        }
    }

    /**
     * 撤销邀请
     * @param id
     * @return
     */
    @PostMapping("/cancel")
    @ResponseBody
    public R cancel(Long id) {
        logger.info("MyInviteController.cancel|id = {}",id);
        TeacherStudent teacherStudent = myApplyService.queryTeacherStudent(id);
        if(teacherStudent == null) {
            return R.error("不存在该记录，撤销失败");
        }
        //修改申请状态
        teacherStudent.setLinkStatus(ConstantVal.LINK_STATUS_CANCEL);
        Integer rows = myApplyService.updateTeacherStudent(teacherStudent);
        if(rows > 0) {
            logger.info("MyInviteController.cancel|修改成功");
            return R.ok();
        }else {
            return R.error();
        }


    }

}
