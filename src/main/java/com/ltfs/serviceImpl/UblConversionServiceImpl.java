package com.ltfs.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltfs.dao.UblConversionDao;
import com.ltfs.pojo.UblConversionPojo;
import com.ltfs.service.UblConversionService;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type UblConversionServiceImpl
 * @purpose 
 */

@Service
public class UblConversionServiceImpl  implements UblConversionService{
	
	String tag = this.getClass().getName();
	Logger CustomLogger = LoggerFactory.getLogger(UblConversionServiceImpl.class);
	
	@Autowired
	UblConversionDao ublConversionDao;
	
	@Override
	public List<UblConversionPojo> getUblConversion(String dsaId) {
		List<UblConversionPojo> list=null;
		CustomLogger.info(tag + "<<----Insite in  getUblConversion ------------->>");
		CustomLogger.info("|-->Request Data-==>>" + dsaId);
		try {
			list=ublConversionDao.getUblConversion(dsaId);
		}catch (Exception ex) {
			CustomLogger.error(tag + "Exception in search getUblConversion", ex);
		}
		CustomLogger.info(tag + "<<==-Response Data-<--|:" + list);
		
		return list;
	}

}
