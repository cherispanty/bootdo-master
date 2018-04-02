package com.bootdo.common.service.impl;

import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.dao.FileDao;
import com.bootdo.common.dao.MyDocumentDao;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.FileService;
import com.bootdo.common.service.MyDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.List;
import java.util.Map;


@Service
public class MyDocumentServiceImpl implements MyDocumentService {
	@Autowired
	private MyDocumentDao myDocumentDao;

	@Autowired
	private BootdoConfig bootdoConfig;
	@Override
	public FileDO get(Long id){
		return myDocumentDao.get(id);
	}
	
	@Override
	public List<FileDO> list(Map<String, Object> map){
		return myDocumentDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return myDocumentDao.count(map);
	}
	
	@Override
	public int save(FileDO sysFile){
		return myDocumentDao.save(sysFile);
	}
	
	@Override
	public int update(FileDO sysFile){
		return myDocumentDao.update(sysFile);
	}
	
	@Override
	public int remove(Long id){
		return myDocumentDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return myDocumentDao.batchRemove(ids);
	}

    @Override
    public Boolean isExist(String url) {
		Boolean isExist = false;
		if (!StringUtils.isEmpty(url)) {
			String filePath = url.replace("/files/", "");
			filePath = bootdoConfig.getUploadPath() + filePath;
			File file = new File(filePath);
			if (file.exists()) {
				isExist = true;
			}
		}
		return isExist;
	}
	}
