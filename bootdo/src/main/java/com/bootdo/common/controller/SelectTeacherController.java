package com.bootdo.common.controller;

import com.bootdo.common.config.Constant;
import com.bootdo.common.domain.DictDO;
import com.bootdo.common.dto.TeacherDTO;
import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.service.DictService;
import com.bootdo.common.service.SelectTeacherService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ShiroUtils;
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
 * 字典表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-29 18:28:07
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
	@RequiresPermissions("common:selectTeacher:selectTeacher")
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
     * 保存一条申请记录
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(TeacherStudent teacherStudent) {
//        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
//        }
//        if (dictService.save(dict) > 0) {
//            return R.ok();
//        }
        logger.info("SelectTeacherController.teacherStudent()|teacherStudent = {}",teacherStudent.toString());
        if(selectTeacherService.saveApplyRecord(teacherStudent) > 0) {
            return R.ok();
        }
        return R.error();
    }
}
