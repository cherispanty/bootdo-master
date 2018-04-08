package com.bootdo.common.service.impl;

import com.bootdo.common.dao.TeacherUploadDao;
import com.bootdo.common.domain.FileDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Linchong
 * @date 2018/4/8 17:57
 */
@Service
public class TeacherUploadService {
    @Autowired
    private TeacherUploadDao tud;
    private Logger logger = LoggerFactory.getLogger(TeacherUploadService.class);

    public FileDO queryFile(Long id) {
        logger.info("TeacherUploadService.queryFile|id = {}",id);
        FileDO file = tud.queryFile(id);
        return file;
    }
    //保存老师上传资料的备注
    public Integer saveFile(FileDO fileDO) {
        logger.info("TeacherUploadService.saveFile|fileDO = {}",fileDO.toString());
        return tud.saveTeacherComment(fileDO);
    }
}
