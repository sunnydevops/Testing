package com.ltfs.serviceImpl;

import java.util.Map;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ltfs.service.MdsService;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 15-Jul-2020
 * @type MdsServiceImpl
 * @purpose 
 */
@Service
public class MdsServiceImpl implements MdsService{
	
	Logger LOGGER = LoggerFactory.getLogger(MdsServiceImpl.class);
	
	@Value( "${mdsAuthHeader}" )
	private String mdsAuthHeader;
	
	@Value( "${getMdsApi}" )
	private String mdsApi;
	
	@Value( "${insertMdsApi}" )
	private String insertMdsApi;
	
	@Value( "${kulizaLoginUrl}" )
	private String kulizaLoginUrl;
	
	@Value( "${kulizaTokenBody}" )
	private String kulizaTokenBody;
	
	@Override
	public String getMdsMaster(String reqBody) {
		LOGGER.info("getMdsMaster called reqBody == "+reqBody);
		LOGGER.info("mdsAuthHeader= "+mdsAuthHeader);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization",mdsAuthHeader);
		HttpEntity<String> entity = new HttpEntity<>(reqBody,headers);
		JSONObject res=restTemplate.postForObject(mdsApi,entity,JSONObject.class);
		LOGGER.info("response of MDS  == "+ res);
		if(res !=null && res.containsKey("ResultJson"))
		{
			LOGGER.info("response contains key ResultJson");
			String resultJson=res.get("ResultJson").toString();
			if(resultJson!=null && !"".equals(resultJson))
				return resultJson;
		}
		
		LOGGER.info("response not contains key ResultJson or containing empty  ResultJson key" );
		return null;
	}

	@Override
	public String insertMdsMaster(String slug, String data) {
		LOGGER.info("insertMdsMaster called slug == "+slug);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization",getMdsToken());
		String reqBody="";
		reqBody="{ \"slug\" : "+"\""+slug+"\""+", \"data\" : "+data+" }";
		LOGGER.info("request body= "+reqBody);
		HttpEntity<String> entity = new HttpEntity<>(reqBody,headers);
		String res=restTemplate.postForObject(insertMdsApi,entity,String.class);
		LOGGER.info("response of MDS  == "+ res);
		return res;
	}
	private String getMdsToken()
	{ 
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(kulizaTokenBody,headers);
		JSONObject res=restTemplate.postForObject(kulizaLoginUrl,entity,JSONObject.class);
		LOGGER.info("kuliza response for login   == "+ res.toString());
		if(res.containsKey("data")){
			Map data=(Map) res.get("data");
			if(data.containsKey("access_token")){
				String token=data.get("access_token").toString();
				LOGGER.info("kuliza token == "+token);
				return token;
			}
		}
		LOGGER.info("returning null from getMdsToken ... ");
		return null;
	}
}
