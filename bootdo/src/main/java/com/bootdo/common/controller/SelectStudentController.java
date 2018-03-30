package com.bootdo.common.controller;

import com.bootdo.common.dto.DeptDTO;
import com.bootdo.common.dto.StudentDTO;
import com.bootdo.common.dto.TeacherDTO;
import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.service.SelectTeacherService;
import com.bootdo.common.service.impl.SelectStudentService;
import com.bootdo.common.service.impl.SelectTeacherServiceImpl;
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
 * @email 1992lcg@163.com
 * @date 2017-09-29 18:28:07
 */

@Controller
@RequestMapping("/common/selectStudent")
public class SelectStudentController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(SelectStudentController.class);
	@Autowired
	private SelectStudentService selectStudentService;
	@Autowired
	private SelectTeacherServiceImpl stsi;
	@Autowired
	private SelectTeacherService selectTeacherService;
	@GetMapping()
	String selectTeacher() {
		return "common/selectStudent/selectStudent";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
//		// 查询列表数据
		logger.info("SelectStudentController.list|params = {}",params.toString());
		Query query = new Query(params);
		List<StudentDTO> studentList = selectStudentService.queryStudentList(query);
		logger.info("SelectStudentController.list|查询结果为 studentList = {}",studentList.toString());
		Integer count = selectStudentService.countTotal(query);
		logger.info("SelectStudentController.list|查询条数为 count = {}",count);
		PageUtils pageUtils = new PageUtils(studentList,count);
		return pageUtils;
	}

	@GetMapping("/dept")
	@ResponseBody
	public List<DeptDTO> listAllClass() {
		return selectStudentService.queryAllClass();
	}

	@GetMapping("/invite/{userId}")
	String invite(@PathVariable("userId") Long userId, Model model) {
		logger.info("SelectStudentController.invite|userId = {}",userId);
		StudentDTO studentDTO = selectStudentService.queryStudentById(userId);
		//组装邀请记录
		TeacherStudent ts = new TeacherStudent();
		ts.setStudentId(studentDTO.getUserId());
		ts.setStudentName(studentDTO.getName());
		ts.setClassName(studentDTO.getClassName());
		ts.setTeacherId(ShiroUtils.getUserId());
		logger.info("SelectStudentController.invite()|ts = {}",ts.toString());
		model.addAttribute("ts",ts);
		return "common/selectStudent/invite";
	}


	/**
	 * 添加老师邀请记录
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(TeacherStudent teacherStudent) {
		logger.info("SelectStudentController.save()|teacherStudent = {}",teacherStudent.toString());
		//添加老师邀请标识，type = 1
		teacherStudent.setType(ConstantVal.TEACHER_TYPE_INVITE);
		if(stsi.saveTeacherStudent(teacherStudent) > 0) {
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
		logger.info("SelectStudentController.check|userId = {}",userId);
		Map<String, Object> map = new HashMap<>();
		map.put("studentId",userId);
		map.put("teacherId",ShiroUtils.getUserId());
		List<TeacherStudent> tsList = selectTeacherService.queryRecordBySidAndTid(map);
		if(tsList != null && tsList.size() > 0) {
			for (TeacherStudent ts:
					tsList) {
				if(ts.getLinkStatus() == ConstantVal.LINK_STATUS_APPLY && ts.getType() == ConstantVal.STUDENT_TYPE_APPLY) {
					return R.error("该学生已经申请了你，快去回复他吧");
				}
				if(ts.getLinkStatus() == ConstantVal.LINK_STATUS_APPLY && ts.getType() == ConstantVal.TEACHER_TYPE_INVITE) {
					return R.error("你已经邀请了该学生，请等待他的回复");
				}
			}
		}
		//允许申请
		return R.ok();
	}

}
