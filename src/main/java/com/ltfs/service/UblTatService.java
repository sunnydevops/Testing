package com.ltfs.service;

import java.util.List;

import com.ltfs.pojo.UblTatPojo;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type UbltatService
 * @purpose 
 */
public interface UblTatService {
	
	List<UblTatPojo> getUblTat(String dsaId);

}
