package com.bootdo.common.controller;

import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.domain.PaperDO;
import com.bootdo.common.dto.PaperDTO;
import com.bootdo.common.service.impl.MyDocumentServiceImpl;
import com.bootdo.common.service.impl.MyPaperService;
import com.bootdo.common.service.impl.StudentPaperService;
import com.bootdo.common.utils.*;
import org.apache.fop.area.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理我的文档
 * @author linchong
 * @email 13298684463@163.com
 */
@Controller
@RequestMapping("/common/studentPaper")
public class StudentPaperController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(StudentPaperController.class);
	@Autowired
    private StudentPaperService sps;

	@GetMapping()
//	@RequiresPermissions("common:sysFile:sysFile")
	String sysFile(Model model) {
		Map<String, Object> params = new HashMap<>(16);
		return "common/studentPaper/studentPaper";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		logger.info("StudentPaperController.list|params = {}",params.toString());
		params.put("teacherId",ShiroUtils.getUserId());
        Query query = new Query(params);
        logger.info("StudentPaperController.list|query = {}",query.toString());
        List<PaperDTO> listPaper = sps.listPaper(query);
        Integer total = sps.countTotal(query);
        PageUtils pageUtils = new PageUtils(listPaper,total);
        logger.info("StudentPaperController.list|pageUtils = {}",pageUtils.toString());
        return pageUtils;
    }


}
