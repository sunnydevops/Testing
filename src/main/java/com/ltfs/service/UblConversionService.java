package com.ltfs.service;

import java.util.List;

import com.ltfs.pojo.UblConversionPojo;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type UblConversionService
 * @purpose 
 */
public interface UblConversionService {
	
	List<UblConversionPojo> getUblConversion(String dsaId);

}
