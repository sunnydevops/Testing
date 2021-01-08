package com.ltfs.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import com.ltfs.service.MdsService;

/**
 * @author Mustak Bagwan
 * @email mustakbagwan@ltfs.com
 * @created 15-Jul-2020
 * @type PromoMaster
 * @purpose 
 */
//@Component
//@EnableScheduling
public class MdsMasterScheduler {
	
	Logger LOGGER = LoggerFactory.getLogger(MdsMasterScheduler.class);
	
	@Autowired
	MdsService mdsService;
	
	@Value( "${mdsPromoBody}" )
	private String mdsPromoBody;
	
	@Value( "${mdsCountryBody}" )
	private String mdsCountryBody;
	
	@Value( "${mdsStateBody}" )
	private String mdsStateBody;
	
	@Value( "${mdsCityBody}" )
	private String mdsCityBody;
	
	@Value( "${mdsCityTierBody}" )
	private String mdsCityTierBody;
	
	@Value( "${mdsPincodeBody}" )
	private String mdsPincodeBody;
	
	
	@Value( "${mdsPromoToCustomerCategory}" )
	private String mdsPromoToCustomerCategory;
	
	@Value( "${mdsPromoToDocumentType}" )
	private String mdsPromoToDocumentType;
	
	@Value( "${mdsPromoToEligibilityProgramType}" )
	private String mdsPromoToEligibilityProgramType;
	
	@Value( "${mdsEmployerCategoryType}" )
	private String mdsEmployerCategoryType;
	
	@Value( "${mdsOrganisationType}" )
	private String mdsOrganisationType;
	
	@Value( "${mdsProductType}" )
	private String mdsProductType;
	
	@Value( "${mdsProfessionType}" )
	private String mdsProfessionType;
	
	@Value( "${mdsPromoChildDSAMapping}" )
	private String mdsPromoChildDSAMapping;
	
	@Value( "${mdsPromoParentDSAMapping}" )
	private String mdsPromoParentDSAMapping;
	
	@Value( "${mdsPromoPincodeMapping}" )
	private String mdsPromoPincodeMapping;
	
	@Value( "${mdsDsaChild}" )
	private String mdsDsaChild;
	
	
	@Value( "${mdsDsaParent}" )
	private String mdsDsaParent;
	
	@Value( "${mdsFlsDst}" )
	private String mdsFlsDst;
	
	@Value( "${mdsBranch}" )
	private String mdsBranch;
	
	@Value( "${mdsPincode}" )
	private String mdsPincode;
	
	
	@Scheduled(cron = "${cronTime}")
	public void countryMaster()
	{
		
		LOGGER.info("countryMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsCountryBody);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("country-master", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void stateMaster()
	{
		
		LOGGER.info("stateMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsStateBody);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("state-master-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void cityMaster()
	{
		
		LOGGER.info("cityMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsCityBody);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("city-master-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void cityTierMaster() 
	{
		
		LOGGER.info("cityTierMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsCityTierBody);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("ltfs-promocitytier-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void pincodeMaster() 
	{
		
		LOGGER.info("pincodeMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsPincodeBody);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("pincode-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	@Scheduled(cron = "${cronTime}")
	public void promoToCustomerCategoryMaster() 
	{
		
		LOGGER.info("promoToCustomerCategoryMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsPromoToCustomerCategory);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("ltfs-promcustomcat-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void promoToDocumentTypeMaster() 
	{
		
		LOGGER.info("promoToDocumentTypeMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsPromoToDocumentType);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("ltfs-promodoc-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void promoToEligibilityProgramTypeMaster() 
	{
		
		LOGGER.info("promoToEligibilityProgramTypeMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsPromoToEligibilityProgramType);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("ltfs-promoeligprog-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void EmployerCategoryTypeMaster() 
	{
		
		LOGGER.info("EmployerCategoryTypeMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsEmployerCategoryType);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("ltfs-promoempcate-ltfs", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void organisationTypeMaster() 
	{
		
		LOGGER.info("organisationTypeMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsOrganisationType);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("ltfs-promotoorg-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void productTypeMaster() 
	{
		
		LOGGER.info("productTypeMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsProductType);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("ltfs-promotoprod-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void professionTypeMaster() 
	{
		
		LOGGER.info("professionTypeMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsProfessionType);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("ltfs-promo-profess-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void mdsPromoChildDSAMappingMaster() 
	{
		
		LOGGER.info("mdsPromoChildDSAMappingMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsPromoChildDSAMapping);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("ltfs-promochilddsa-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void mdsPromoParentDSAMappingMaster() 
	{
		
		LOGGER.info("mdsPromoParentDSAMappingMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsPromoParentDSAMapping);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("ltfs-promoparendsa-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void mdsPromoPincodeMappingMaster() 
	{
		
		LOGGER.info("mdsPromoPincodeMappingMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsPromoPincodeMapping);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("ltfs-promo-pincode-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void mdsDsaChildMaster() 
	{
		
		LOGGER.info("mdsDsaChildMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsDsaChild);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("dsa-child-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	@Scheduled(cron = "${cronTime}")
	public void mdsDsaParentMaster() 
	{
		
		LOGGER.info("mdsDsaParentMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsDsaParent);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("dsa-parent-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void mdsFlsDstMaster() 
	{
		
		LOGGER.info("mdsFlsDstMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsFlsDst);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("fls-dst-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void mdsBranchMaster() 
	{
		
		LOGGER.info("mdsBranchMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsBranch);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("branch-master-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void mdsPincodeMaster() 
	{
		
		LOGGER.info("mdsPincodeMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsPincode);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("pincode-latest", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	@Scheduled(cron = "${cronTime}")
	public void promoMaster()
	{
		
		LOGGER.info("promoMaster called ");
		LOGGER.info("calling getMdsMaster.... ");
		String data=mdsService.getMdsMaster(mdsPromoBody);
		
		if(data !=null && !data.equals(""))
		{
			LOGGER.info("calling insertMdsMaster.... ");
		   String res=mdsService.insertMdsMaster("ltfs-promo-master-main", data);
		   LOGGER.info("response of insert mds service == "+res);
		}else
		{
			LOGGER.info("invalid response from mds..  "+data);
		}
	}
	
	
	
}
