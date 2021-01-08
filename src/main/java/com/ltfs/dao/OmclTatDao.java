package com.ltfs.dao;

import java.util.List;

import com.ltfs.pojo.UblTatPojo;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type OmclTatDao
 * @purpose 
 */
public interface OmclTatDao {
	
	List<UblTatPojo> getOmclTat(String dsaId);

}