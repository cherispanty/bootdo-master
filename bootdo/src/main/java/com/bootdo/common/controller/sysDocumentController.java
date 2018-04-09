package com.bootdo.common.controller;

import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.config.Constant;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.impl.MyDocumentServiceImpl;
import com.bootdo.common.service.impl.SysDocumentService;
import com.bootdo.common.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RequestMapping("/common/sysDocument")
public class sysDocumentController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(sysDocumentController.class);
	@Autowired
	private SysDocumentService sds;

	@GetMapping()
//	@RequiresPermissions("common:sysFile:sysFile")
	String sysFile(Model model) {
		Map<String, Object> params = new HashMap<>(16);
		return "common/sysDocument/sysDocument";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		logger.info("SysDocumentController.list|params = {}",params.toString());
		// 查询列表数据
        Query query = new Query(params);
        List<FileDO> fileList = sds.queryAllFile(query);
        Integer total = sds.countTotal(query);
        PageUtils pageUtils = new PageUtils(fileList,total);
        return pageUtils;
    }


    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("common:dict:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        sds.batchRemove(ids);
        return R.ok();
    }


}
