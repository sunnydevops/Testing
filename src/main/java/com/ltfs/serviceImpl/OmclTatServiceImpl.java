package com.ltfs.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltfs.dao.OmclTatDao;
import com.ltfs.pojo.UblTatPojo;
import com.ltfs.service.OmclTatService;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type OmclTatServiceImpl
 * @purpose 
 */
@Service
public class OmclTatServiceImpl implements OmclTatService{
	
	Logger CustomLogger = LoggerFactory.getLogger(OmclTatServiceImpl.class);
	
	@Autowired
	OmclTatDao omclTatDao;
	
	@Override
	public List<UblTatPojo> getOmclTat(String dsaId) {
		List<UblTatPojo> list=null;
		CustomLogger.info("<<----Insite in  getOmclTat ------------->>");
		
		CustomLogger.info("|-->Request Data-==>>" + dsaId);
		try {
			list=omclTatDao.getOmclTat(dsaId);
		}catch (Exception ex) {
			CustomLogger.error("Exception in search getOmclTat", ex);
		}
		CustomLogger.info("<<==-Response Data-<--|:" + list);
		
		return list;
	}

}
