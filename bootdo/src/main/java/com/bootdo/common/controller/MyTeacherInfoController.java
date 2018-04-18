package com.bootdo.common.controller;

import com.bootdo.common.domain.TeacherStudentDO;
import com.bootdo.common.dto.StudentDTO;
import com.bootdo.common.dto.TeacherDTO;
import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.service.impl.MyApplyService;
import com.bootdo.common.service.impl.MyTeacherInfoService;
import com.bootdo.common.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/3/27 15:21
 */
@Controller
@RequestMapping("/common/myTeacherInfo")
public class MyTeacherInfoController {
    private Logger logger = LoggerFactory.getLogger(MyTeacherInfoController.class);
    @Autowired
    private MyTeacherInfoService myTeacherInfoService;
    @GetMapping()
    public String myApply() {
        return "common/myTeacherInfo/myTeacherInfo";
    }

    /**
     * 查询我的导师信息
     * @return
     */
    @ResponseBody
    @GetMapping("/list")
    public PageUtils list() {
        logger.info("MyTeacherInfoController.list|开始查询我的导师");
        //查询我的导师是否存在
        List<TeacherStudentDO> tsList = myTeacherInfoService.queryMyTeacherId(ShiroUtils.getUserId());
        if(tsList == null) {
            logger.info("我还没有导师，赶快去申请");
            return null;
        }
        /*if(idList.size() > 1) {
            logger.info("逻辑异常，该学生拥有多个导师！");
            return null;
        }*/

        //拥有至少一位导师（我们要尽力避免出现超过一位老师的情况）
        if(tsList.size() > 0) {
            List<TeacherDTO> teacherList = new ArrayList<>();
            for (TeacherStudentDO ts: tsList) {
                TeacherDTO teacherDTO = myTeacherInfoService.queryMyTeacherByTeacherId(ts.getTeacherId());
                if(teacherDTO != null) {
                    teacherDTO.setPaperTitle(ts.getPaperTitle());
                }
                teacherList.add(teacherDTO);
            }
            PageUtils pageUtils = new PageUtils(teacherList,tsList.size());
            return pageUtils;
        }
        return null;
    }

}
