package com.bootdo.common.controller;

import com.bootdo.common.config.Constant;
import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.service.impl.MyApplyService;
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
@RequestMapping("/common/myApply")
public class MyApplyController {
    private Logger logger = LoggerFactory.getLogger(MyApplyController.class);
    @Autowired
    private MyApplyService myApplyService;

    @GetMapping()
    public String myApply() {
        return "common/myApply/myApply";
    }

    /**
     * 查询我的申请记录
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/list")
    public PageUtils list(@RequestParam Map<String, Object> params) throws Exception {
        logger.info("MyApplyController.list()|params = {}",params.toString());
        params.put("studentId", ShiroUtils.getUserId());
        //只筛选出我的申请，排除老师的邀请
        params.put("type", ConstantVal.STUDENT_TYPE_APPLY);
        logger.info("MyApplyController.list()|params = {}",params.toString());
        Query query = new Query(params);
        try{
            List<TeacherStudent> teacherStudentList = myApplyService.queryMyApply(query);
            if(teacherStudentList != null && teacherStudentList.size() > 0){
                String studentName = ShiroUtils.getUser().getName();
                //添加学生信息
                for (TeacherStudent ts:
                        teacherStudentList) {
                    ts.setStudentName(studentName);
                }
            }
            Integer total = myApplyService.countTotal(query);
            PageUtils pageUtils = new PageUtils(teacherStudentList,total);
            logger.info("MyApplyController.list()|pageUtils = {}",pageUtils.toString());
            return pageUtils;
        }catch (BDException e) {
            logger.info("MyApplyController.list()|查询失败 原因 = {}",e.getMessage());
            throw e;
        }catch (Exception e){
            logger.info("MyApplyController.list()|查询失败",e);
            throw e;
        }
    }

    /**
     * 检测是否可以取消申请
     * @param id
     * @return
     */
    @PostMapping("/check")
    @ResponseBody
    public R check(Long id) {
        TeacherStudent teacherStudent = myApplyService.queryTeacherStudent(id);
        if(teacherStudent == null) {
            return R.error("在该申请状态下不允许操作");
        }
        if(teacherStudent.getLinkStatus() == 0) {
            return R.ok();
        }
        return R.error("在该申请状态下不允许操作");
    }

    /**
     * 取消申请
     * @param id
     * @return
     */
    @PostMapping("/cancel")
    @ResponseBody
    public R cancel(Long id) {
        logger.info("MyApplyController.cancel|id = {}",id);
        TeacherStudent teacherStudent = myApplyService.queryTeacherStudent(id);
        if(teacherStudent == null) {
            return R.error("不存在该记录，取消失败");
        }
        //修改申请状态
        teacherStudent.setLinkStatus(ConstantVal.LINK_STATUS_CANCEL);
        Integer rows = myApplyService.updateTeacherStudent(teacherStudent);
        if(rows > 0) {
            logger.info("MyApplyController.cancel|修改成功");
            return R.ok();
        }else {
            return R.error();
        }


    }
}
