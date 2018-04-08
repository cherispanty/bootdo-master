package com.bootdo.common.dao;

import com.bootdo.common.domain.FileDO;
import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Linchong
 * @date 2018/4/8 17:40
 */
@Mapper
public interface TeacherUploadDao {
    FileDO queryFile(Long id);
    //保存老师评论
    Integer saveTeacherComment(FileDO file);
}
