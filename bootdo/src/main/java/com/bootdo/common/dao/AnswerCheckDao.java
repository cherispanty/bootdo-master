package com.bootdo.common.dao;

import com.bootdo.common.dto.PaperDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**答辩审核
 * @author Linchong
 * @date 2018/4/9 10:17
 */
@Mapper
public interface AnswerCheckDao {
    List<PaperDTO> listPaper(Map<String, Object> map);
    Integer countTotal(Map<String, Object> map);
    PaperDTO queryPaperById(Long id);
    Integer savePaper(PaperDTO paperDTO);

}
