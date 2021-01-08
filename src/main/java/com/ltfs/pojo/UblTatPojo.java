package com.ltfs.pojo;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type UblTatPojo
 * @purpose 
 */
public class UblTatPojo {
	
	private String monthYear;
	private String dsaId;
	private int loginToSanctionHrs;
	private int sanctionToDisbursementHrs;
	private String etlLoadDate;
	/**
	 * @return the monthYear
	 */
	public String getMonthYear() {
		return monthYear;
	}
	/**
	 * @param monthYear the monthYear to set
	 */
	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}
	/**
	 * @return the dsaId
	 */
	public String getDsaId() {
		return dsaId;
	}
	/**
	 * @param dsaId the dsaId to set
	 */
	public void setDsaId(String dsaId) {
		this.dsaId = dsaId;
	}
	/**
	 * @return the loginToSanctionHrs
	 */
	public int getLoginToSanctionHrs() {
		return loginToSanctionHrs;
	}
	/**
	 * @param loginToSanctionHrs the loginToSanctionHrs to set
	 */
	public void setLoginToSanctionHrs(int loginToSanctionHrs) {
		this.loginToSanctionHrs = loginToSanctionHrs;
	}
	/**
	 * @return the sanctionToDisbursementHrs
	 */
	public int getSanctionToDisbursementHrs() {
		return sanctionToDisbursementHrs;
	}
	/**
	 * @param sanctionToDisbursementHrs the sanctionToDisbursementHrs to set
	 */
	public void setSanctionToDisbursementHrs(int sanctionToDisbursementHrs) {
		this.sanctionToDisbursementHrs = sanctionToDisbursementHrs;
	}
	/**
	 * @return the etlLoadDate
	 */
	public String getEtlLoadDate() {
		return etlLoadDate;
	}
	/**
	 * @param etlLoadDate the etlLoadDate to set
	 */
	public void setEtlLoadDate(String etlLoadDate) {
		this.etlLoadDate = etlLoadDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UblTatPojo [monthYear=" + monthYear + ", dsaId=" + dsaId + ", loginToSanctionHrs=" + loginToSanctionHrs
				+ ", sanctionToDisbursementHrs=" + sanctionToDisbursementHrs + ", etlLoadDate=" + etlLoadDate + "]";
	}
	

}
