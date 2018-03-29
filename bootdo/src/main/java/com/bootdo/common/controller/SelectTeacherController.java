package com.bootdo.common.controller;

import com.bootdo.common.config.Constant;
import com.bootdo.common.domain.DictDO;
import com.bootdo.common.dto.TeacherDTO;
import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.service.DictService;
import com.bootdo.common.service.SelectTeacherService;
import com.bootdo.common.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RequestMapping("/common/selectTeacher")
public class SelectTeacherController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(SelectTeacherController.class);
	@Autowired
	private SelectTeacherService selectTeacherService;

	@GetMapping()
	String selectTeacher() {
		return "common/selectTeacher/selectTeacher";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
//		// 查询列表数据
		logger.info("SelectTeacherController.list|params = {}",params.toString());
		Query query = new Query(params);
		List<TeacherDTO> teacherList = selectTeacherService.queryTeacherList(query);
		logger.info("SelectTeacherController.list|查询结果为 teacherList = {}",teacherList.toString());
		int count = selectTeacherService.count(query);
		logger.info("SelectTeacherController.list|查询条数为 count = {}",count);
		PageUtils pageUtils = new PageUtils(teacherList,count);
		return pageUtils;
	}

	@GetMapping("/apply/{userId}")
	String apply(@PathVariable("userId") Long userId, Model model) {
//		DictDO dict = dictService.get(id);
//		model.addAttribute("dict", dict);
//		return "common/dict/edit";
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
     * 判断该老师是否邀请了自己，并且状态为未查看，如果邀请了并且为“未查看”状态就不可以再去申请
     * @param userId
     * @return
     */
    @PostMapping("/check")
    @ResponseBody
    public R check(Long userId) {
        logger.info("SelectTeacherController.check|userId = {}",userId);
        Map<String, Object> map = new HashMap<>();
        map.put("teacherId",userId);
        map.put("studentId",ShiroUtils.getUserId());
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
