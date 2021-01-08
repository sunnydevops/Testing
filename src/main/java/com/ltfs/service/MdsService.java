package com.ltfs.service;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 15-Jul-2020
 * @type MdsService
 * @purpose 
 */
public interface MdsService {
	
	public String getMdsMaster(String reqBody);
	public String insertMdsMaster(String slug,String data);
	
}
