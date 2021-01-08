package com.ltfs.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltfs.dao.UblTatDao;
import com.ltfs.pojo.UblConversionPojo;
import com.ltfs.pojo.UblTatPojo;
import com.ltfs.service.UblTatService;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type UblTatServiceImpl
 * @purpose 
 */
@Service
public class UblTatServiceImpl implements UblTatService{
	
	Logger CustomLogger = LoggerFactory.getLogger(UblTatServiceImpl.class);
	
	@Autowired
	UblTatDao ublTatDao;
	
	@Override
	public List<UblTatPojo> getUblTat(String dsaId) {
		List<UblTatPojo> list=null;
		CustomLogger.info("<<----Insite in  getUblTat ------------->>");
		
		CustomLogger.info("|-->Request Data-==>>" + dsaId);
		try {
			list=ublTatDao.getUblTat(dsaId);
		}catch (Exception ex) {
			CustomLogger.error("Exception in search getUblTat", ex);
		}
		CustomLogger.info("<<==-Response Data-<--|:" + list);
		
		return list;
	}

}
