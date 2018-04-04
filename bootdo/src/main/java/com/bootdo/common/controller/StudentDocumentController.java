package com.bootdo.common.controller;

import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.dto.TeacherDTO;
import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.service.impl.MyDocumentServiceImpl;
import com.bootdo.common.service.impl.StudentDocumentService;
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
	private StudentDocumentService sds;
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
        params.put("teacherId",ShiroUtils.getUserId());
		Query query = new Query(params);
		List<FileDO> sysFileList = sds.list(query);
		int total = sds.countTotal(query);
		PageUtils pageUtils = new PageUtils(sysFileList, total);
		return pageUtils;
	}

	/**
	 * 老师评论前回显文档信息
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/comment/{id}")
	String comment(@PathVariable("id") Long id, Model model) {
		logger.info("StudentDocumentController.comment|id = {}",id);
        FileDO file = sds.queryFileById(id);
        model.addAttribute("file",file);
        return "common/studentDocument/comment";
	}


    /**
     * 保存老师评论信息
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(FileDO fileDO) {
        logger.info("StudentDocumentController.save()|fileDO = {}",fileDO.toString());
        Map<String, Object> map = new HashMap<>();
        map.put("id",fileDO.getId());
        map.put("teacherComment",fileDO.getTeacherComment());
        logger.info("StudentDocumentController.save()|map = {}",map.toString());
        Integer rows = sds.updateComment(map);
        if(rows > 0) {
            return R.ok();
        }
        return R.error();
    }

}
