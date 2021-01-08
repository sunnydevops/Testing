package com.ltfs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ltfs.model.ProductsAgreExposureModel;

/**
 * @author Sandip Shinde
 * @email sandip.shinde@cmss.in
 * @created 19-May-2020
 * @type AllProductsAgreExposureRepo
 * @purpose 
 */
@Repository
public interface ProductsAgreExposureRepo extends CrudRepository<ProductsAgreExposureModel, String>{
	List<ProductsAgreExposureModel> findByMeanKey(String meanKey);
}
