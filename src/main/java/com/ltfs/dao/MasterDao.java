package com.ltfs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MasterDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<String> test()
	{
		String qry="select Code  from [Promo Master Sme] ";
		List<String> list=jdbcTemplate.queryForList(qry,String.class);
		
		return list;
	}
	
	/*public String test()
	{
		String qry="SELECT GETDATE()";
		
		String res=jdbcTemplate.queryForObject(qry, String.class);	
		return res;
	}*/
	
}
