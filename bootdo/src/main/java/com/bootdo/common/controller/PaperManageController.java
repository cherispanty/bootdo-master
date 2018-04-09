package com.bootdo.common.controller;

import com.bootdo.common.dto.PaperDTO;
import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.service.impl.PaperManageService;
import com.bootdo.common.service.impl.StudentPaperService;
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
@RequestMapping("/common/paperManage")
public class PaperManageController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(PaperManageController.class);
	@Autowired
	private PaperManageService pms;

	@GetMapping()
//	@RequiresPermissions("common:sysFile:sysFile")
	String sysFile(Model model) {
		Map<String, Object> params = new HashMap<>(16);
		return "common/paperManage/paperManage";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		logger.info("PaperManageController.list|params = {}",params.toString());
		Query query = new Query(params);
        Integer total = pms.countTotal(query);
        List<PaperDTO> paperList = pms.listPaper(query);
        PageUtils pageUtils = new PageUtils(paperList,total);
        return pageUtils;
    }

    /**
     * 显示论文详情
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/detail/{id}")
    String detail(@PathVariable("id") Long id, Model model) {
        logger.info("PaperManageController.detail|id = {}",id);
        PaperDTO paper = pms.findPaperById(id);
        model.addAttribute("paper",paper);
        return "common/paperManage/detail";
    }

    @ResponseBody
    @PostMapping("/save")
    public R save(PaperDTO paperDTO) {
        logger.info("PaperManageController.save()|paperDTO = {}",paperDTO.toString());
        pms.savePaperDetail(paperDTO);
        return R.ok();
    }
}
