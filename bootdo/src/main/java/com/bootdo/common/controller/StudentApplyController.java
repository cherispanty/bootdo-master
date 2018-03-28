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
@RequestMapping("/common/studentApply")
public class StudentApplyController {
    private Logger logger = LoggerFactory.getLogger(StudentApplyController.class);
    @Autowired
    private StudentApplyService studentApplyService;
    @Autowired
    private MyApplyService myApplyService;

    @GetMapping()
    public String myApply() {
        return "common/studentApply/studentApply";
    }

    /**
     * 查询学生的申请记录
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/list")
    public PageUtils list(@RequestParam Map<String, Object> params) throws Exception {
        logger.info("StudentApplyController.list()|params = {}",params.toString());
        params.put("teacherId", ShiroUtils.getUserId());
        logger.info("MyApplyController.list()|params = {}",params.toString());
        Query query = new Query(params);
        try{
            //查询当前筛选条件下的学生申请记录
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
     * 同意该学生的申请
     * @param id
     * @return
     */
    @PostMapping("/agree")
    @ResponseBody
    public R agree(Long id) {
        logger.info("MyApplyController.agree|id = {}",id);
        //通过id查询该申请记录
        TeacherStudent teacherStudent = myApplyService.queryTeacherStudent(id);
        if(teacherStudent == null) {
            logger.info("MyApplyController.agree|teacherStudent = {}",teacherStudent);
            return R.error("操作失败，该记录不存在");
        }
        //修改link_status状态为同意状态
        teacherStudent.setLinkStatus(ConstantVal.LINK_STATUS_CONN);
        Integer rows = studentApplyService.updateLinkStatus(teacherStudent);
        if(rows > 0) {
            logger.info("MyApplyController.agree|操作成功");
            return R.ok();
        }
        return R.error("操作失败");
    }

    /**
     * 拒绝该学生的申请
     * @param id
     * @return
     */
    @PostMapping("/disagree")
    @ResponseBody
    public R disagree(Long id) {
        logger.info("MyApplyController.disagree|id = {}",id);
        //通过id查询该申请记录
        TeacherStudent teacherStudent = myApplyService.queryTeacherStudent(id);
        if(teacherStudent == null) {
            logger.info("MyApplyController.disagree|teacherStudent = {}",teacherStudent);
            return R.error("操作失败，该记录不存在");
        }
        //修改link_status状态为拒绝状态
        teacherStudent.setLinkStatus(ConstantVal.LINK_STATUS_REFUSE);
        Integer rows = studentApplyService.updateLinkStatus(teacherStudent);
        if(rows > 0) {
            logger.info("MyApplyController.disagree|操作成功");
            return R.ok();
        }
        return R.error("操作失败");
    }

}
