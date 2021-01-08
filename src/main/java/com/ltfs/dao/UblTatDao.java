package com.ltfs.dao;

import java.util.List;

import com.ltfs.pojo.UblTatPojo;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type UblTatDao
 * @purpose 
 */
public interface UblTatDao {
	
	List<UblTatPojo> getUblTat(String dsaId);

}