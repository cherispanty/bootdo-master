package com.bootdo.common.controller;

import com.bootdo.common.dto.PaperDTO;
import com.bootdo.common.service.impl.AnswerCheckService;
import com.bootdo.common.service.impl.PaperManageService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
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
@RequestMapping("/common/answerCheck")
public class AnswerCheckController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(AnswerCheckController.class);
	@Autowired
	private PaperManageService pms;
    @Autowired
    private AnswerCheckService acs;
	@GetMapping()
//	@RequiresPermissions("common:sysFile:sysFile")
	String sysFile(Model model) {
		Map<String, Object> params = new HashMap<>(16);
		return "common/answerCheck/answerCheck";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		logger.info("AnswerCheckController.list|params = {}",params.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        //只查询今年的论文
        String year = sdf.format(date);
        params.put("createTime",year);
		Query query = new Query(params);
        Integer total = acs.countTotal(query);
        List<PaperDTO> paperList = acs.listPaper(query);
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
        logger.info("AnswerCheckController.detail|id = {}",id);
        PaperDTO paper = acs.findPaperById(id);
        model.addAttribute("paper",paper);
        return "common/answerCheck/detail";
    }

    @ResponseBody
    @PostMapping("/save")
    public R save(PaperDTO paperDTO) {
        logger.info("AnswerCheckController.save()|paperDTO = {}",paperDTO.toString());
        acs.savePaper(paperDTO);
        return R.ok();
    }
}
