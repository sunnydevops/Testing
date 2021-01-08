package com.ltfs.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltfs.model.ProductsAgreExposureModel;
import com.ltfs.repository.ProductsAgreExposureRepo;
import com.ltfs.service.ProductsAgreExposureService;

/**
 * @author Sandip Shinde
 * @email sandip.shinde@cmss.in
 * @created 19-May-2020
 * @type ProductsAgreExposureServiceImpl
 * @purpose
 */
@Service
public class ProductsAgreExposureServiceImpl implements ProductsAgreExposureService {

	String tag = this.getClass().getName();
	Logger CustomLogger = LoggerFactory.getLogger(ProductsAgreExposureServiceImpl.class);

	@Autowired(required = true)
	ProductsAgreExposureRepo allProductsAgreExposureRepo;

	@Override
	public ProductsAgreExposureModel getProductsAgreExposure(String meanKey) {
		List<ProductsAgreExposureModel> list = null;
		ProductsAgreExposureModel response = null;
		
		CustomLogger.info(tag + " Inside in ProductsAgreExposureServiceImpl ----->> ");
		CustomLogger.info(tag + " Request Data ----->> " + meanKey);
		try {
			list = allProductsAgreExposureRepo.findByMeanKey(meanKey);
			if (!list.isEmpty()) {
				response = allProductsAgreExposureRepo.findByMeanKey(meanKey).get(0);
			} else {
				CustomLogger.info(tag + "Data not found in databse :" + meanKey);
			}

		} catch (Exception ex) {
			CustomLogger.error(tag + "Exception in search getProductsAgreExposure", ex);
		}
		CustomLogger.info(tag + " Response Data ----->> " + response);
		
		if (response != null) {
			response.setStatus(null);
			response.setLoanType(null);
			response.setLoanAmount(null);
			response.setSanctionDate(null);
			response.setDisbursementDate(null);
			response.setEmiAmount(null);
			response.setCreatedon(null);
			
			response.setDpd_last_month1(response.getDpd_last_month1() != null ? response.getDpd_last_month1() : 0);
			response.setDpd_last_month2(response.getDpd_last_month2() != null ? response.getDpd_last_month2() : 0);
			response.setDpd_last_month3(response.getDpd_last_month3() != null ? response.getDpd_last_month3() : 0);
			
			if (response.getDpd_last_month1() > 0 || response.getDpd_last_month2() > 0|| response.getDpd_last_month3() > 0) {
				response.setDpd_three_months_zero("yes");
			} else {
				response.setDpd_three_months_zero("no");
			}
			
			response.setDpd_last_month1(null);
			response.setDpd_last_month2(null);
			response.setDpd_last_month3(null);
		}
		
		CustomLogger.info(tag + " Response Data Altered ---->> " + response);
		
		return response;
	}

}
