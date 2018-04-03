package com.bootdo.common.dao;

import com.bootdo.common.domain.FileDO;
import com.bootdo.common.dto.PaperDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 文件上传
 * @author linchong
 * @email 13298684463@163.com
 */
@Mapper
public interface MyPaperDao {
	//查询我的论文
	List<PaperDTO> list(Map<String, Object> map);
	Integer countTotal(Map<String, Object> map);
}
