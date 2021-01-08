package com.ltfs.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltfs.dao.OmclConversionDao;
import com.ltfs.pojo.UblConversionPojo;
import com.ltfs.service.OmclConversionService;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type OmclConversionServiceImpl
 * @purpose 
 */

@Service
public class OmclConversionServiceImpl  implements OmclConversionService{
	
	String tag = this.getClass().getName();
	Logger CustomLogger = LoggerFactory.getLogger(OmclConversionServiceImpl.class);
	
	@Autowired
	OmclConversionDao omclConversionDao;
	
	@Override
	public List<UblConversionPojo> getOmclConversion(String dsaId) {
		List<UblConversionPojo> list=null;
		CustomLogger.info(tag + "<<----Insite in  getOmclConversion ------------->>");
		CustomLogger.info("|-->Request Data-==>>" + dsaId);
		try {
			list=omclConversionDao.getOmclConversion(dsaId);
		}catch (Exception ex) {
			CustomLogger.error(tag + "Exception in search getOmclConversion", ex);
		}
		CustomLogger.info(tag + "<<==-Response Data-<--|:" + list);
		
		return list;
	}

}
