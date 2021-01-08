package com.ltfs.webservice;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltfs.pojo.UblConversionPojo;
import com.ltfs.service.UblConversionService;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type UblConversionController
 * @purpose 
 */
@RestController
public class UblConversionController {
	String tag = this.getClass().getName();
	Logger CustomLogger = LoggerFactory.getLogger(UblConversionController.class);
	
	@Autowired
	UblConversionService ublConversionService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ublConversion", produces = "application/json", method = {RequestMethod.POST })
	public @ResponseBody Object getUblConversion(@RequestBody JSONObject json)
	{
		JSONObject response=new JSONObject();
		response.put("status",1001);
		String dsaId=null;
		CustomLogger.info(tag + "<<----Insite in  getUblConversion ------------->>");
		CustomLogger.info("|-->Request Data-==>>" + json);
		try
		{
			if(json!=null) {
				if(json.containsKey("dsaId")) {
					dsaId=json.get("dsaId").toString();
					if(dsaId!=null) {
						if(dsaId.equalsIgnoreCase("")) {
							CustomLogger.info("Invalid dsaId value empty");
							response.put("error","Invalid dsaId value empty");
						}else {
							List<UblConversionPojo> list=ublConversionService.getUblConversion(dsaId);
							
							if(list!=null && !list.isEmpty()) {
								response.put("status",200);
								response.put("data",list);
							}else {
								CustomLogger.info("Data not found in Database");
								response.put("error","Data not found in Database");
							}
						}
						
					}else {
						CustomLogger.info("Invalid request dsaId value null");
						response.put("error","Invalid request dsaId value null");
					}
					
				}else {
					CustomLogger.info("Invalid request body key(dsaId) key");
					response.put("error","Invalid request body key(dsaId) key");
				}
				
			}else {
				CustomLogger.info("Invalid requst body");
				response.put("error","Invalid requst body");
			}
		}
		catch (Exception ex) {
			CustomLogger.error(tag + "Exception in search getUblConversion", ex);
			response.put("status",500);
		}
		CustomLogger.info(tag + "<<==-Response Data-<--|:" + response);
		return response;
		
	}
	

}
