package com.bootdo.common.controller;

import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.impl.MyDocumentServiceImpl;
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
 * 管理我的文档
 * @author linchong
 * @email 13298684463@163.com
 */
@Controller
@RequestMapping("/common/studentDocument")
public class StudentDocumentController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(StudentDocumentController.class);
//	@Autowired
//	private FileService mdsi;
	@Autowired
	private MyDocumentServiceImpl mdsi;
	@Autowired
	private BootdoConfig bootdoConfig;

	@GetMapping()
//	@RequiresPermissions("common:sysFile:sysFile")
	String sysFile(Model model) {
		Map<String, Object> params = new HashMap<>(16);
		return "common/studentDocument/studentDocument";
	}

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

	@GetMapping("/add")
	// @RequiresPermissions("common:bComments")
	String add() {
		return "common/sysFile/add";
	}

	@GetMapping("/edit")
	// @RequiresPermissions("common:bComments")
	String edit(Long id, Model model) {
		FileDO sysFile = mdsi.get(id);
		model.addAttribute("sysFile", sysFile);
		return "common/sysFile/edit";
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
//	@RequiresPermissions("common:info")
	public R info(@PathVariable("id") Long id) {
		FileDO sysFile = mdsi.get(id);
		return R.ok().put("sysFile", sysFile);
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
//	@RequiresPermissions("common:save")
	public R save(FileDO sysFile) {
		if (mdsi.save(sysFile) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
//	@RequiresPermissions("common:update")
	public R update(@RequestBody FileDO sysFile) {
		mdsi.update(sysFile);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	// @RequiresPermissions("common:remove")
	public R remove(Long id, HttpServletRequest request) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
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

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
//	@RequiresPermissions("common:remove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		mdsi.batchRemove(ids);
		return R.ok();
	}

	@ResponseBody
	@PostMapping("/upload")
	R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		//原始文档名
		String name = file.getOriginalFilename();
		System.out.println("name:"+name);
		String fileName = FileUtil.renameToUUID(name);
		System.out.println("filename:"+fileName);
		Long userId = ShiroUtils.getUserId();
        System.out.println("userId:"+userId);
        String userName = ShiroUtils.getUser().getName();
        System.out.println("userName:"+userName);
        FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date(),name,userId,userName);
		try {
			FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath(), fileName);
		} catch (Exception e) {
			return R.error();
		}

		if (mdsi.save(sysFile) > 0) {
			return R.ok().put("fileName",sysFile.getUrl());
		}
		return R.error();
	}

    //删除上传的文档（物理删除）
//    @PostMapping("/remove")
//    @ResponseBody
//    public R remove(Long id) {
//        logger.info("MyDocumentController.remove|id = {}",id);
//        int rows = mdsi.remove(id);
//        if(rows > 0) {
//            return R.ok();
//        }else {
//            return R.error();
//        }
//    }


}
