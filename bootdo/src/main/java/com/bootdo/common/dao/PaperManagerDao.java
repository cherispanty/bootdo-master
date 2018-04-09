package com.bootdo.common.dao;

import com.bootdo.common.domain.FileDO;
import com.bootdo.common.dto.PaperDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**论文管理（注意这里的名字PaperManagerDao是比其他的地方多了一个'r'的）
 * @author Linchong
 * @date 2018/4/9 10:17
 */
@Mapper
public interface PaperManagerDao {
    List<PaperDTO> listPaper(Map<String, Object> map);
    Integer countTotal(Map<String, Object> map);
    PaperDTO queryPaperById(Long id);
    Integer savePaperDetail(PaperDTO paperDTO);
}
