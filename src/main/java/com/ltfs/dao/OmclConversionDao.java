package com.ltfs.dao;

import java.util.List;

import com.ltfs.pojo.UblConversionPojo;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type OmclConversionDao
 * @purpose 
 */
public interface OmclConversionDao {
	
	List<UblConversionPojo> getOmclConversion(String dsaId);

}