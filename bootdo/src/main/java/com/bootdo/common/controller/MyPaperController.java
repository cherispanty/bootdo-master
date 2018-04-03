package com.bootdo.common.controller;

import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.domain.PaperDO;
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

	//上传毕业论文
    @ResponseBody
    @PostMapping("/upload")
    R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
	    //原始文件名
        String name = file.getOriginalFilename();
        System.out.println("name:"+name);
		String fileName = FileUtil.renameToUUID(name);
		System.out.println("filename:"+fileName);
        Long studentId = ShiroUtils.getUserId();
        //获得指导老师id
        Long teacherId = myPaperService.queryMyteacherId(studentId);
        if(teacherId == null) {
            logger.info("MyPaperController.upload|检查到该学生没有指导老师");
            return R.error("你还没有指导老师，不能上传论文");
        }
        PaperDO sysFile = new PaperDO(name,studentId,"/files/"+fileName,teacherId,FileType.fileType(fileName));
        try {
            FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath(), fileName);
        } catch (Exception e) {
            return R.error();
        }

        if (myPaperService.save(sysFile) > 0) {
            return R.ok().put("fileName",sysFile.getUrl());
        }
        return R.error();
    }

    //查看论文明细
    @GetMapping("/detail/{id}")
    String detail(@PathVariable("id") Long id, Model model) {
        logger.info("MyPaperController.detail|id = {}",id);
        PaperDO paperDO = myPaperService.queryPaperDetail(id);
        model.addAttribute("paper",paperDO);
        return "common/myPaper/detail";
    }

    //撤销上传的论文
    @PostMapping("/cancel")
    @ResponseBody
    public R cancel(Long id) {
	    logger.info("MyPaperController.cancel|id = {}",id);
        Integer rows = myPaperService.cancelPaper(id);
        if(rows > 0) {
            return R.ok();
        }else {
            return R.error();
        }
    }

    //删除上传的论文（逻辑删除）
    @PostMapping("/remove")
    @ResponseBody
    public R remove(Long id) {
        logger.info("MyPaperController.remove|id = {}",id);
        Integer rows = myPaperService.removePaper(id);
        if(rows > 0) {
            return R.ok();
        }else {
            return R.error();
        }
    }
}
