package com.ltfs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Sandip Shinde
 * @email sandip.shinde@cmss.in
 * @created 19-May-2020
 * @type AllProductsAgreExposureModel
 * @purpose
 */

@Entity
@Table(name = "All_products_agre_exposure")
public class ProductsAgreExposureModel {
	@Id
	@Column(name = "\"MEAN KEY\"", updatable = false, nullable = false)
	private String meanKey;

	@Column(name = "STATUS", updatable = false, nullable = true)
	private String status;

	@Column(name = "DPD", updatable = false, nullable = true)
	private Integer dpd;

	@Column(name = "\"Outstanding Amount\"", updatable = false, nullable = true)
	private java.math.BigDecimal outstandingAmount;

	@Column(name = "\"Loan Type\"", updatable = false, nullable = true)
	private String loanType;

	@Column(name = "\"Loan Amount\"", updatable = false, nullable = true)
	private java.math.BigDecimal loanAmount;

	@Column(name = "\"Sanction Date\"", updatable = false, nullable = true)
	private Date sanctionDate;

	@Column(name = "\"Disbursement Date\"", updatable = false, nullable = true)
	private Date disbursementDate;

	@Column(name = "\"EMI Amount\"", updatable = false, nullable = true)
	private java.math.BigDecimal emiAmount;

	@Column(name = "Createdon", updatable = false, nullable = true)
	private java.sql.Timestamp Createdon;
	
	@Column(name = "\"DPD Last Month\"", updatable = false, nullable = true)
	private Integer dpd_last_month1;
	
	@Column(name = "\"DPD Two months ago\"", updatable = false, nullable = true)
	private Integer dpd_last_month2;
	
	@Column(name = "\"DPD Three months ago\"", updatable = false, nullable = true)
	private Integer dpd_last_month3;
	
	@Column(name = "\"DPD Max\"", updatable = false, nullable = true)
	private Integer dpd_max;
	
	@Transient
	private String dpd_three_months_zero;
	
	/**
	 * @return the meanKey
	 */
	public String getMeanKey() {
		return meanKey;
	}

	/**
	 * @param meanKey the meanKey to set
	 */
	public void setMeanKey(String meanKey) {
		this.meanKey = meanKey;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the dpd
	 */
	public Integer getDpd() {
		return dpd;
	}

	/**
	 * @param dpd the dpd to set
	 */
	public void setDpd(Integer dpd) {
		this.dpd = dpd;
	}

	/**
	 * @return the outstandingAmount
	 */
	public java.math.BigDecimal getOutstandingAmount() {
		return outstandingAmount;
	}

	/**
	 * @param outstandingAmount the outstandingAmount to set
	 */
	public void setOutstandingAmount(java.math.BigDecimal outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	/**
	 * @return the loanType
	 */
	public String getLoanType() {
		return loanType;
	}

	/**
	 * @param loanType the loanType to set
	 */
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	/**
	 * @return the loanAmount
	 */
	public java.math.BigDecimal getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(java.math.BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * @return the sanctionDate
	 */
	public Date getSanctionDate() {
		return sanctionDate;
	}

	/**
	 * @param sanctionDate the sanctionDate to set
	 */
	public void setSanctionDate(Date sanctionDate) {
		this.sanctionDate = sanctionDate;
	}

	/**
	 * @return the disbursementDate
	 */
	public Date getDisbursementDate() {
		return disbursementDate;
	}

	/**
	 * @param disbursementDate the disbursementDate to set
	 */
	public void setDisbursementDate(Date disbursementDate) {
		this.disbursementDate = disbursementDate;
	}

	/**
	 * @return the emiAmount
	 */
	public java.math.BigDecimal getEmiAmount() {
		return emiAmount;
	}

	/**
	 * @param emiAmount the emiAmount to set
	 */
	public void setEmiAmount(java.math.BigDecimal emiAmount) {
		this.emiAmount = emiAmount;
	}

	/**
	 * @return the createdon
	 */
	public java.sql.Timestamp getCreatedon() {
		return Createdon;
	}

	/**
	 * @param createdon the createdon to set
	 */
	public void setCreatedon(java.sql.Timestamp createdon) {
		Createdon = createdon;
	}

	/**
	 * @return the dpd_last_month1
	 */
	public Integer getDpd_last_month1() {
		return dpd_last_month1;
	}

	/**
	 * @param dpd_last_month1 the dpd_last_month1 to set
	 */
	public void setDpd_last_month1(Integer dpd_last_month1) {
		this.dpd_last_month1 = dpd_last_month1;
	}

	/**
	 * @return the dpd_last_month2
	 */
	public Integer getDpd_last_month2() {
		return dpd_last_month2;
	}

	/**
	 * @param dpd_last_month2 the dpd_last_month2 to set
	 */
	public void setDpd_last_month2(Integer dpd_last_month2) {
		this.dpd_last_month2 = dpd_last_month2;
	}

	/**
	 * @return the dpd_last_month3
	 */
	public Integer getDpd_last_month3() {
		return dpd_last_month3;
	}

	/**
	 * @param dpd_last_month3 the dpd_last_month3 to set
	 */
	public void setDpd_last_month3(Integer dpd_last_month3) {
		this.dpd_last_month3 = dpd_last_month3;
	}

	/**
	 * @return the dpd_max
	 */
	public Integer getDpd_max() {
		return dpd_max;
	}

	/**
	 * @param dpd_max the dpd_max to set
	 */
	public void setDpd_max(Integer dpd_max) {
		this.dpd_max = dpd_max;
	}

	/**
	 * @return the dpd_three_months_zero
	 */
	public String getDpd_three_months_zero() {
		return dpd_three_months_zero;
	}

	/**
	 * @param dpd_three_months_zero the dpd_three_months_zero to set
	 */
	public void setDpd_three_months_zero(String dpd_three_months_zero) {
		this.dpd_three_months_zero = dpd_three_months_zero;
	}
	
	
}
