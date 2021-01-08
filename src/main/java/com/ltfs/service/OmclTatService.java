package com.ltfs.service;

import java.util.List;

import com.ltfs.pojo.UblTatPojo;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type OmclTatService
 * @purpose 
 */
public interface OmclTatService {
	
	List<UblTatPojo> getOmclTat(String dsaId);

}
