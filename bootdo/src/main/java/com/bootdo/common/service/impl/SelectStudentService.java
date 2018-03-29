package com.bootdo.common.service.impl;

import com.bootdo.common.dao.SelectStudentDao;
import com.bootdo.common.dto.DeptDTO;
import com.bootdo.common.dto.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/3/27 18:04
 */
@Service
public class SelectStudentService {
    private Logger logger = LoggerFactory.getLogger(SelectStudentService.class);
    @Autowired
    private SelectStudentDao selectStudentDao;

    /**
     * 查询学生列表
     * @param map
     * @return
     */
    public List<StudentDTO> queryStudentList(Map<String, Object> map) {
        logger.info("SelectStudentService.queryStudentList|map = {}",map.toString());
        List<StudentDTO> studentDTOList = selectStudentDao.queryStudentList(map);
        logger.info("SelectStudentService.queryStudentList|studentDTOList = {}",studentDTOList.toString());
        return studentDTOList;
    }

    public Integer countTotal(Map<String, Object> map) {
        logger.info("SelectStudentService.countTotal|map = {}",map.toString());
        Integer total = selectStudentDao.countTotal(map);
        return total;
    }

    /**
     * 查询所有班级信息
     * @return
     */
    public List<DeptDTO> queryAllClass() {
        return selectStudentDao.queryDeptInfo();
    }

    public StudentDTO queryStudentById(Long userId) {
        logger.info("SelectStudentService.queryStudentById|userId = {}",userId);
        StudentDTO studentDTO = selectStudentDao.queryStudentById(userId);
        return studentDTO;
    }
}
