package com.bootdo.common.controller;

import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.dto.StudentDTO;
import com.bootdo.common.service.impl.StudentDocumentService;
import com.bootdo.common.service.impl.TeacherResourceService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ShiroUtils;
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
 * 管理我的文档
 * @author linchong
 * @email 13298684463@163.com
 */
@Controller
@RequestMapping("/common/teacherResource")
public class TeacherResourceController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(TeacherResourceController.class);
	@Autowired
	private TeacherResourceService trs;

	@GetMapping()
//	@RequiresPermissions("common:sysFile:sysFile")
	String sysFile(Model model) {
		Map<String, Object> params = new HashMap<>(16);
		return "common/teacherResource/teacherResource";
	}

	@ResponseBody
	@GetMapping("/list")
//	@RequiresPermissions("common:sysFile:sysFile")
	public PageUtils list(@RequestParam Map<String, Object> params) {
	    logger.info("TeacherResourceController.list|params = {}",params.toString());
		// 查询列表数据
        params.put("studentId",ShiroUtils.getUserId());
		Query query = new Query(params);
		List<FileDO> sysFileList = trs.listFile(query);
		int total = trs.countTotal(query);
		PageUtils pageUtils = new PageUtils(sysFileList, total);
		return pageUtils;
	}



}
