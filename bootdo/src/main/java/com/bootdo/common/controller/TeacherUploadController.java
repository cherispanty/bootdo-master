package com.bootdo.common.controller;

import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.impl.MyDocumentServiceImpl;
import com.bootdo.common.service.impl.TeacherUploadService;
import com.bootdo.common.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 老师：我已上传
 * @author linchong
 * @email 13298684463@163.com
 */
@Controller
@RequestMapping("/common/teacherUpload")
public class TeacherUploadController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(TeacherUploadController.class);
	@Autowired
	private MyDocumentServiceImpl mdsi;
	@Autowired
	private BootdoConfig bootdoConfig;
	@Autowired
	private TeacherUploadService tus;
	@GetMapping()
//	@RequiresPermissions("common:sysFile:sysFile")
	String sysFile(Model model) {
		Map<String, Object> params = new HashMap<>(16);
		return "common/teacherUpload/teacherUpload";
	}

	/**
	 * 这里直接调用MyDocumentServiceImpl的service层的方法
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/list")
//	@RequiresPermissions("common:sysFile:sysFile")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
        params.put("userId",ShiroUtils.getUserId());
		Query query = new Query(params);
		List<FileDO> sysFileList = mdsi.list(query);
		int total = mdsi.count(query);
		PageUtils pageUtils = new PageUtils(sysFileList, total);
		return pageUtils;
	}

	@GetMapping("/comment/{id}")
	String comment(@PathVariable("id") Long id, Model model) {
		logger.info("TeacherUploadController.comment|id = {}",id);
		FileDO fileDO = tus.queryFile(id);
		model.addAttribute("file",fileDO);
		return "common/teacherUpload/comment";
	}

	@ResponseBody
	@PostMapping("/save")
	public R save(FileDO fileDO) {
		logger.info("TeacherUploadController.save()|fileDO = {}",fileDO.toString());
		//不管结果返回什么，都返回成功，因为如果数据库更新的内容没有更新那么影响的行数也是0，这种情况是合法的
		tus.saveFile(fileDO);
		return R.ok();
	}

	/**
	 * 删除该资料
	 * @param id
	 * @param request
	 * @return
	 */
	@PostMapping("/remove")
	@ResponseBody
	// @RequiresPermissions("common:remove")
	public R remove(Long id, HttpServletRequest request) {
		String fileName = bootdoConfig.getUploadPath() + mdsi.get(id).getUrl().replace("/files/", "");
		if (mdsi.remove(id) > 0) {
			boolean b = FileUtil.deleteFile(fileName);
			if (!b) {
				return R.error("数据库记录删除成功，文件删除失败");
			}
			return R.ok();
		} else {
			return R.error();
		}
	}


}
