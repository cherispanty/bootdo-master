package com.bootdo.common.controller;

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
        logger.info("MyApplyController.list()|params = {}",params.toString());
        Query query = new Query(params);
        try{
            List<TeacherStudent> teacherStudentList = myApplyService.queryMyApply(query);
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
}
