package com.bootdo.common.controller;

import com.bootdo.common.dto.StudentDTO;
import com.bootdo.common.dto.TeacherDTO;
import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.service.impl.MyStudentListService;
import com.bootdo.common.service.impl.MyTeacherInfoService;
import com.bootdo.common.utils.*;
import org.apache.velocity.runtime.directive.ForeachScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/3/30 11:38
 */
@Controller
@RequestMapping("/common/myStudentList")
public class MyStudentListController {
    private Logger logger = LoggerFactory.getLogger(MyStudentListController.class);
    @Autowired
    private MyStudentListService msls;
    @GetMapping()
    String myStudentList() {
        return "common/myStudentList/myStudentList";
    }

    /**
     * 查询我的学生信息
     * @return
     */
    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        logger.info("MyStudentListController.list|开始查询我的学生");
        params.put("teacherId",ShiroUtils.getUserId());
        Query query = new Query(params);
        logger.info("MyStudentListController.list|query = {}",query.toString());
        List<TeacherStudent> tsList = msls.querySidAndPt(query);
        if(tsList == null) {
            logger.info("MyStudentListController.list|该老师还没有学生");
            return null;
        }
        if(tsList.size() > 0) {
            logger.info("MyStudentListController.list|tsList = {}",tsList.toString());
            List<StudentDTO> studentList = new ArrayList<>();
            //查询我的学生记录条数
            Integer total = msls.countTotal(query);
            for (TeacherStudent ts:
                 tsList) {
                Long studentId = ts.getStudentId();
                String paperTitle = ts.getPaperTitle();
                logger.info("MyStudentListController.list|studentId = {},paperTitle = {}",studentId,paperTitle);
                StudentDTO studentDTO = msls.queryStudent(studentId);
                studentDTO.setPaperTitle(paperTitle);
                logger.info("MyStudentListController.list|studentDTO = {}",studentDTO.toString());
                studentList.add(studentDTO);
            }
            PageUtils pageUtils = new PageUtils(studentList,total);
            return pageUtils;
        }
        return null;
    }

    /**
     * 回显学生信息
     * @param userId
     * @param model
     * @return
     */
    @GetMapping("/edit/{userId}")
    String edit(@PathVariable("userId") Long userId, Model model) {
        logger.info("MyStudentListController.edit|userId = {}",userId);
        StudentDTO studentDTO = msls.queryStudent(userId);
        //通过一种比较傻逼的方式设置paperTitle
        Map<String, Object> map = new HashMap<>();
        map.put("teacherId",ShiroUtils.getUserId());
        List<TeacherStudent> tsList = msls.querySidAndPt(map);
        Long studentId = studentDTO.getUserId();
        for (TeacherStudent ts:
                tsList) {
            logger.info("studentId = {},ts.studentId = {}",studentId,ts.getStudentId());
           if(studentId == ts.getStudentId() || studentId.equals(ts.getStudentId())) {
               studentDTO.setPaperTitle(ts.getPaperTitle());
               break;
           }
        }
        logger.info("MyStudentListController.edit|studentDTO = {}",studentDTO.toString());
        model.addAttribute("stu",studentDTO);
        return "common/myStudentList/edit";
    }

    /**
     * 录入或修改论文题目
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(StudentDTO studentDTO) {
        logger.info("MyStudentListController.save|studentDTO = {}",studentDTO.toString());
        TeacherStudent ts = new TeacherStudent();
        ts.setTeacherId(ShiroUtils.getUserId());
        ts.setStudentId(studentDTO.getUserId());
        ts.setPaperTitle(studentDTO.getPaperTitle());
        Integer rows = msls.updatePaperTile(ts);
        if(rows > 0) {
            logger.info("MyStudentListController.save|录入或更新论文题目成功");
            return R.ok();
        }else {
            logger.info("MyStudentListController.save|录入或更新论文题目失败");
            return R.error();
        }
    }

    /**
     * 解除老师和学生的绑定（link_status: 1 -> -3）
     * 将学生设置为无导师状态（has_teacher=0）
     * @param userId
     * @return
     */
    @PostMapping("/dismiss")
    @ResponseBody
    public R dismiss(Long userId) {
        logger.info("MyStudentListController.dismiss|userId = {}",userId);
        Map<String, Object> map = new HashMap<>();
        map.put("teacherId",ShiroUtils.getUserId());
        map.put("studentId",userId);
        map.put("linkStatus",ConstantVal.LINK_STATUS_UNBIND);
        Integer rows = msls.dismissTeacherAndStudent(map);
        if(rows > 0) {
            logger.info("MyStudentListController.dismiss|解除绑定成功");
            //将学生设置为无导师状态（has_teacher=0）
            msls.updateHasTeacher(userId);
            return R.ok();
        }else {
            logger.info("MyStudentListController.dismiss|解除绑定失败");
            return R.error();
        }
    }
}
