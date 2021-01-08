package com.ltfs.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ltfs.dao.UblTatDao;
import com.ltfs.pojo.UblTatPojo;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type UblTatDaoImpl
 * @purpose 
 */

@Repository
public class UblTatDaoImpl implements UblTatDao {
	Logger CustomLogger = LoggerFactory.getLogger(UblTatDaoImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<UblTatPojo> getUblTat(String dsaId) {
		CustomLogger.info( "<<----Insite in  getUblTat ------------->>");
		CustomLogger.info("|-->Request Data-==>>" + dsaId);
		CustomLogger.info("|-->performing query" );
		String query="select MonthYear,dsa_user,AvgSanctionToDisbHrs,AvgLoginToSanctionHrs,etl_load_date from ubl_tat where dsa_user=?  ";
		List<UblTatPojo> list =jdbcTemplate.query(query,new Object[] {dsaId},new RowMapper<UblTatPojo>() {

			@Override
			public UblTatPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
				UblTatPojo pojo=new UblTatPojo();
				pojo.setMonthYear(rs.getString("MonthYear"));
				pojo.setDsaId(rs.getString("dsa_user"));
				pojo.setSanctionToDisbursementHrs(rs.getInt("AvgSanctionToDisbHrs"));
				pojo.setLoginToSanctionHrs(rs.getInt("AvgLoginToSanctionHrs"));
				pojo.setEtlLoadDate(rs.getString("etl_load_date"));
				return pojo;
			}
			
		});
		CustomLogger.info("|-->returning from dao " );
		return list;
	}
	

}
