package com.ltfs.pojo;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 09-Jun-2020
 * @type UblConversionPojo
 * @purpose 
 */
public class UblConversionPojo {
	
	 private String monthYear;
	
	 private int noOfApplications;
	
	 private String dsaId;
	
	 private int loginToSanctionCount;
	
	 private double loginToSanctionPercent;
	
	 private int sanctionToDisbursementCount;
	
	 private double sanctionToDisbursementPercent;
	
	 private String type;
	
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
	 * @return the noOfApplications
	 */
	public int getNoOfApplications() {
		return noOfApplications;
	}

	/**
	 * @param noOfApplications the noOfApplications to set
	 */
	public void setNoOfApplications(int noOfApplications) {
		this.noOfApplications = noOfApplications;
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
	 * @return the loginToSanctionCount
	 */
	public int getLoginToSanctionCount() {
		return loginToSanctionCount;
	}

	/**
	 * @param loginToSanctionCount the loginToSanctionCount to set
	 */
	public void setLoginToSanctionCount(int loginToSanctionCount) {
		this.loginToSanctionCount = loginToSanctionCount;
	}

	/**
	 * @return the loginToSanctionPercent
	 */
	public double getLoginToSanctionPercent() {
		return loginToSanctionPercent;
	}

	/**
	 * @param loginToSanctionPercent the loginToSanctionPercent to set
	 */
	public void setLoginToSanctionPercent(double loginToSanctionPercent) {
		this.loginToSanctionPercent = loginToSanctionPercent;
	}

	/**
	 * @return the sanctionToDisbursementCount
	 */
	public int getSanctionToDisbursementCount() {
		return sanctionToDisbursementCount;
	}

	/**
	 * @param sanctionToDisbursementCount the sanctionToDisbursementCount to set
	 */
	public void setSanctionToDisbursementCount(int sanctionToDisbursementCount) {
		this.sanctionToDisbursementCount = sanctionToDisbursementCount;
	}

	/**
	 * @return the sanctionToDisbursementPercent
	 */
	public double getSanctionToDisbursementPercent() {
		return sanctionToDisbursementPercent;
	}

	/**
	 * @param sanctionToDisbursementPercent the sanctionToDisbursementPercent to set
	 */
	public void setSanctionToDisbursementPercent(double sanctionToDisbursementPercent) {
		this.sanctionToDisbursementPercent = sanctionToDisbursementPercent;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
		return "UblConversionPojo [monthYear=" + monthYear + ", noOfApplications=" + noOfApplications + ", dsaId="
				+ dsaId + ", loginToSanctionCount=" + loginToSanctionCount + ", loginToSanctionPercent="
				+ loginToSanctionPercent + ", sanctionToDisbursementCount=" + sanctionToDisbursementCount
				+ ", sanctionToDisbursementPercent=" + sanctionToDisbursementPercent + ", type=" + type
				+ ", etlLoadDate=" + etlLoadDate + "]";
	}

}
