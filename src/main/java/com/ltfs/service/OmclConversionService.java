package com.ltfs.service;

import java.util.List;

import com.ltfs.pojo.UblConversionPojo;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type OmclConversionService
 * @purpose 
 */
public interface OmclConversionService {
	
	List<UblConversionPojo> getOmclConversion(String dsaId);

}
