package com.bootdo.common.service;

import com.bootdo.system.domain.UserDO;

import java.util.List;
import java.util.Map;

/**
 * Created by Linchong on 2018/3/18.
 */
public interface SelectTeacherService {
    //查询老师信息
    List<UserDO> queryTeacherList(Map<String, Object> map);
}
