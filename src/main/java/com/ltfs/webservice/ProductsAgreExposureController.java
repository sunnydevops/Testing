package com.ltfs.webservice;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltfs.model.ProductsAgreExposureModel;
import com.ltfs.service.ProductsAgreExposureService;

/**
 * @author Sandip Shinde
 * @email sandip.shinde@cmss.in
 * @created 19-May-2020
 * @type ProductsAgreExposureController
 * @purpose
 */
@RestController
public class ProductsAgreExposureController {

	String tag = this.getClass().getName();
	Logger CustomLogger = LoggerFactory.getLogger(ProductsAgreExposureController.class);

	@Autowired
	ProductsAgreExposureService productsAgreExposureService;

	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value = "/productsAgreExposure", produces = "application/json", method = { RequestMethod.POST })
	public @ResponseBody Object getProductsAgreExposure(@RequestBody JSONObject json) {
		JSONObject response = new JSONObject();
		response.put("status", 1001);
		String meanKey = null;
		CustomLogger.info(tag + " Inside ProductsAgreExposure ----->> ");
		CustomLogger.info(tag + " Request Data ----->> " + json);
		try {
			if (json != null) {
				if (json.containsKey("lan")) {
					meanKey = json.get("lan").toString();
					if (meanKey != null) {
						if (meanKey.equalsIgnoreCase("")) {
							CustomLogger.info(tag + "Invalid lan value empty");
							response.put("error", "Invalid lan value empty");
						} else {
							ProductsAgreExposureModel bean = productsAgreExposureService.getProductsAgreExposure(meanKey);
							if (bean != null) {
								response.put("status", 200);
								response.put("data", bean);
							} else {
								CustomLogger.info(tag + "Data not found in Database");
								response.put("error", "Data not found in Database");
							}
						}
					} else {
						CustomLogger.info(tag + "Invalid request lan value null");
						response.put("error", "Invalid request lan value null");
					}
				} else {
					CustomLogger.info(tag + "Invalid request body key(lan) key");
					response.put("error", "Invalid request body key(lan) key");
				}
			} else {
				CustomLogger.info(tag + "Invalid requst body");
				response.put("error", "Invalid requst body");
			}

		} catch (Exception ex) {
			CustomLogger.error(tag + "Exception in search productsAgreExposure", ex);
			response.put("status", 500);
		}
		CustomLogger.info(tag + " Response Data ----->> " + response);
		return response;

	}

}
