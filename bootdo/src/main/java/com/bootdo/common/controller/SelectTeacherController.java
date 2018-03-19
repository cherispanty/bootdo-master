package com.bootdo.common.controller;

import com.bootdo.common.config.Constant;
import com.bootdo.common.domain.DictDO;
import com.bootdo.common.service.DictService;
import com.bootdo.common.service.SelectTeacherService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
//		Query query = new Query(params);
//		List<DictDO> dictList = dictService.list(query);
//		int total = dictService.count(query);
//		PageUtils pageUtils = new PageUtils(dictList, total);
//		return pageUtils;
		return null;
	}
}
