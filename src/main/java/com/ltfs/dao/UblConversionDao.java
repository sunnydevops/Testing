package com.ltfs.dao;

import java.util.List;

import com.ltfs.pojo.UblConversionPojo;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type UblConversionDao
 * @purpose 
 */
public interface UblConversionDao {
	
	List<UblConversionPojo> getUblConversion(String dsaId);

}