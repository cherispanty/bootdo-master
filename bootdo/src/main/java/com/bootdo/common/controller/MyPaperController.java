package com.bootdo.common.controller;

import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.dto.PaperDTO;
import com.bootdo.common.service.impl.MyDocumentServiceImpl;
import com.bootdo.common.service.impl.MyPaperService;
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
@RequestMapping("/common/myPaper")
public class MyPaperController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(MyPaperController.class);
//	@Autowired
//	private FileService mdsi;
	@Autowired
	private MyDocumentServiceImpl mdsi;
	@Autowired
	private BootdoConfig bootdoConfig;
	@Autowired
	private MyPaperService myPaperService;

	@GetMapping()
//	@RequiresPermissions("common:sysFile:sysFile")
	String sysFile(Model model) {
		Map<String, Object> params = new HashMap<>(16);
		return "common/myPaper/myPaper";
	}

	@ResponseBody
	@GetMapping("/list")
//	@RequiresPermissions("common:sysFile:sysFile")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		logger.info("MyPaperController.list|params = {}",params.toString());
		params.put("studentId",ShiroUtils.getUserId());
		Query query = new Query(params);
		logger.info("MyPaperController.list|query = {}",query.toString());
        Integer total = myPaperService.countTotal(query);
        List<PaperDTO> list = myPaperService.list(query);
        PageUtils pageUtils = new PageUtils(list, total);
		return pageUtils;
	}

//    @ResponseBody
//    @PostMapping("/upload")
//    R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
//        String fileName = file.getOriginalFilename();
//        System.out.println("filename:"+fileName);
////		fileName = FileUtil.renameToUUID(fileName);
////		System.out.println("filename:"+fileName);
//        FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
//        try {
//            FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath(), fileName);
//        } catch (Exception e) {
//            return R.error();
//        }
//
//        if (sysFileService.save(sysFile) > 0) {
//            return R.ok().put("fileName",sysFile.getUrl());
//        }
//        return R.error();
//    }


}
