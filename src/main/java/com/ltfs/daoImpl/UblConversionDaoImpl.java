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

import com.ltfs.dao.UblConversionDao;
import com.ltfs.pojo.UblConversionPojo;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type UblConversionDaoImpl
 * @purpose 
 */
@Repository
public class UblConversionDaoImpl implements UblConversionDao {
	String tag = this.getClass().getName();
	Logger CustomLogger = LoggerFactory.getLogger(UblConversionDaoImpl.class);
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<UblConversionPojo> getUblConversion(String dsaId) {
		CustomLogger.info(tag + "<<----Insite in  getUblConversion ------------->>");
		CustomLogger.info("|-->Request Data-==>>" + dsaId);
		CustomLogger.info("|-->performing query" );
		String query="select MonthYear,No_OF_APPS,dsa_user,saction_count,SanctionPercent,disbursement_count,DisbPercent,TYPE,ETL_LOAD_DATE from ubl_conversion where dsa_user = ? ";
		List<UblConversionPojo> list=jdbcTemplate.query(query, new  Object[] {dsaId},new RowMapper<UblConversionPojo>() {

			@Override
			public UblConversionPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
				UblConversionPojo pojo=new UblConversionPojo();
				pojo.setMonthYear(rs.getString("MonthYear"));
				pojo.setNoOfApplications(rs.getInt("No_OF_APPS"));
				pojo.setDsaId(rs.getString("dsa_user"));
				pojo.setLoginToSanctionCount(rs.getInt("saction_count"));
				pojo.setLoginToSanctionPercent(rs.getDouble("SanctionPercent"));
				pojo.setSanctionToDisbursementCount(rs.getInt("disbursement_count"));
				pojo.setSanctionToDisbursementPercent(rs.getDouble("DisbPercent"));
				pojo.setType(rs.getString("TYPE"));
				pojo.setEtlLoadDate(rs.getString("ETL_LOAD_DATE"));
				return pojo;
			}
			
		});
		CustomLogger.info("|-->returning from dao " );
		return list;
	}

}
