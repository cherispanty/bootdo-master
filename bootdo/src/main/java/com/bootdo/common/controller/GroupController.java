package com.bootdo.common.controller;

import com.bootdo.common.dto.TeacherDTO;
import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.service.SelectTeacherService;
import com.bootdo.common.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author linchong
 * @email 714987173@qq.com
 */

@Controller
@RequestMapping("/common/group")
public class GroupController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(GroupController.class);
	@Autowired
	private SelectTeacherService selectTeacherService;

	@GetMapping()
	String selectTeacher() {
		return "common/group/group";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
//		// 查询列表数据
		logger.info("SelectTeacherController.list|params = {}",params.toString());
		Query query = new Query(params);
		List<TeacherDTO> teacherList = selectTeacherService.queryTeacherList(query);
		Map<String, Object> map = new HashMap<>();
		//查找老师所带学生人数和正在申请该老师的人数
		if(teacherList != null && teacherList.size() >0) {
            for (TeacherDTO t:
                    teacherList) {
                map.put("teacherId",t.getUserId());
                //查找正在申请该老师的学生人数
                map.put("linkStatus",ConstantVal.LINK_STATUS_APPLY);
                Integer readyNum = selectTeacherService.findNumsOfTeacher(map);
                t.setReadyNum(readyNum);
                //查找该老师已经带了多少学生
                map.put("linkStatus",ConstantVal.LINK_STATUS_CONN);
                Integer alreadyNum = selectTeacherService.findNumsOfTeacher(map);
                t.setAlreadyNum(alreadyNum);
            }
        }

		logger.info("SelectTeacherController.list|查询结果为 teacherList = {}",teacherList.toString());
		int count = selectTeacherService.count(query);
		logger.info("SelectTeacherController.list|查询条数为 count = {}",count);
		PageUtils pageUtils = new PageUtils(teacherList,count);
		return pageUtils;
	}

	@GetMapping("/apply/{userId}")
	String apply(@PathVariable("userId") Long userId, Model model) {
        TeacherDTO teacherDTO = selectTeacherService.queryTeacherByUserId(userId);
        //组装申请记录
        TeacherStudent ts = new TeacherStudent();
        ts.setTeacherId(teacherDTO.getUserId());
        ts.setStudentId(ShiroUtils.getUserId());
        ts.setResearchDirection(teacherDTO.getResearchDirection());
        ts.setDeptName(teacherDTO.getDeptName());
        ts.setTeacherName(teacherDTO.getName());
        logger.info("SelectTeacherController.apply()|ts = {}",ts.toString());
        model.addAttribute("ts",ts);
        return "common/selectTeacher/apply";
    }

    /**
     * 保存一条老师-学生关联记录
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(TeacherStudent teacherStudent) {
        logger.info("SelectTeacherController.teacherStudent()|teacherStudent = {}",teacherStudent.toString());
        //添加学生申请标记 type = 0
        teacherStudent.setType(ConstantVal.STUDENT_TYPE_APPLY);
        if(selectTeacherService.saveTeacherStudent(teacherStudent) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 判断当前学生是否已有了导师，如果有了就不能申请
     * 判断该老师是否邀请了自己，并且状态为未查看，如果邀请了并且为“未查看”状态就不可以再去申请
     * @param userId
     * @return
     */
    @PostMapping("/check")
    @ResponseBody
    public R check(Long userId) {
        logger.info("SelectTeacherController.check|userId = {}",userId);
        //判断当前学生是否已有了导师，如果有了就不能申请
        Long studentId = ShiroUtils.getUserId();
        Integer rows = selectTeacherService.queryByStudentId(studentId);
        if(rows == 1){
            logger.info("检测到该学生已经有了导师");
            return R.error("你已经有了导师，不能再申请");
        }
        if(rows > 1) {
            logger.info("异常，该学生有超过一名导师");
            return R.error("系统检测你有超过一名导师，请联系管理员");
        }
        //判断该老师是否邀请了自己，并且状态为未查看，如果邀请了并且为“未查看”状态就不可以再去申请
        Map<String, Object> map = new HashMap<>();
        map.put("teacherId",userId);
        map.put("studentId",studentId);
        List<TeacherStudent> tsList = selectTeacherService.queryRecordBySidAndTid(map);
        if(tsList != null && tsList.size() > 0) {
            for (TeacherStudent ts:
                    tsList) {
                if(ts.getLinkStatus() == ConstantVal.LINK_STATUS_APPLY && ts.getType() == ConstantVal.STUDENT_TYPE_APPLY) {
                    return R.error("你已经申请了该导师，请耐心等待老师回复");
                }
                if(ts.getLinkStatus() == ConstantVal.LINK_STATUS_APPLY && ts.getType() == ConstantVal.TEACHER_TYPE_INVITE) {
                    return R.error("该导师已经邀请了你，快去看看吧");
                }
            }
        }
        //允许申请
        return R.ok();
    }
}
