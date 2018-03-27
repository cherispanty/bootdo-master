package com.bootdo.common.service.impl;

import com.bootdo.common.dao.MyApplyDao;
import com.bootdo.common.dto.TeacherStudent;
import com.bootdo.common.utils.BDException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/3/27 15:30
 */
@Service
public class MyApplyService {
    private Logger logger = LoggerFactory.getLogger(MyApplyService.class);
    @Autowired
    private MyApplyDao myApplyDao;

    /**
     * 查询我的申请记录
     * @param map
     * @return
     */
    public List<TeacherStudent> queryMyApply(Map<String, Object> map){
        logger.info("MyApplyService.queryMyApply()|map = {}",map.toString());
        try{
            List<TeacherStudent> teacherStudentList = myApplyDao.queryTeacherStudent(map);
            logger.info("MyApplyService.queryMyApply()|teacherStudentList = {}",teacherStudentList.toString());
            return teacherStudentList;
        }catch (Exception e) {
            logger.info("MyApplyService.queryMyApply()|查询我的申请记录失败");
            throw new BDException("查询失败",e);
        }
    }

    /**
     * 查询申请的记录条数
     * @param map
     * @return
     */
    public Integer countTotal(Map<String, Object> map) {
        logger.info("MyApplyServicecountTotal|map = {}",map.toString());
        return myApplyDao.countTotal(map);
    }
}
