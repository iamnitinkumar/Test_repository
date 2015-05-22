package com.sap.selenium.c4c.components;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class ContactFacetHelper {
	
	private Map<String, String> OportunityFacetIdsData;
	private Map<String, String> SalesLeadFacetIdsData;
	private Map<String, String> MarketingLeadFacetIdsData;
	
	
	private String value;
	private WebDriver webDriver;
	
	// Opportunity object - contact facet ids
	private final String OPPORTUNITY_CONTACTFACET_NAME = "objectvalueselectorGrtVQYv2cqA7l"; // ButtonValueHelp
	private final String OPPORTUNITY_CONTACTFACET_PRIMARY_CONTACT = "checkboxXJgSikVMV4sjW28bY";
	private final String OPPORTUNITY_CONTACTFACET_ROLE = "dropdownlistboxfS7ot7_C9qgGuYT_PJ8NQm";



	private String[] Fields = new String[] { "contact_Name",
			"contact_PrimaryContact", "contact_Role" };

	 {

		OportunityFacetIdsData = new LinkedHashMap<String, String>();
		OportunityFacetIdsData.put("contact_Name",
				this.OPPORTUNITY_CONTACTFACET_NAME);
		OportunityFacetIdsData.put("contact_PrimaryContact",
				this.OPPORTUNITY_CONTACTFACET_PRIMARY_CONTACT);
		OportunityFacetIdsData.put("contact_Role",
				this.OPPORTUNITY_CONTACTFACET_ROLE);

		SalesLeadFacetIdsData = new LinkedHashMap<String, String>();
		SalesLeadFacetIdsData.put("contact_Name",
				"objectvalueselectorAEcRiZidiaQOzULS2OK4nG");
		SalesLeadFacetIdsData.put("contact_PrimaryContact",
				"checkbox5OslsXIfZqk2vZ9Q6eDoB0");
		
		
		MarketingLeadFacetIdsData = new LinkedHashMap<String, String>();
		MarketingLeadFacetIdsData.put("contact_Name",
				"objectvalueselectorO2B31cJ_6K_i4EcbJXwmN0");
		MarketingLeadFacetIdsData.put("contact_PrimaryContact",
				"checkboxXW6RsZi_s_sqwM2uqUIDv1Zm");

	}
	 
	 public ContactFacetHelper(WebDriver webDriver)
	 {
		 this.webDriver = webDriver;
	 }

	public  void Check(String TiName) {
		
		System.out.println("Ti Name is" + TiName);
		
		switch (TiName) {
		
		
		case "Saleslead":

			new ContactFacet(this.webDriver).demo(Compare(SalesLeadFacetIdsData));

			break;
		case "Opportunity":

			new ContactFacet(this.webDriver).demo(Compare(OportunityFacetIdsData));

			break;
			
		case "MarketingLead":

			new ContactFacet(this.webDriver).demo(Compare(MarketingLeadFacetIdsData));

			break;
		default: // Optional
			// Statements
		}
	}

	private  Map<String, String> Compare(Map<String, String> map) {

		Map<String, String> result = new LinkedHashMap<String, String>();

		for (String key : map.keySet()) {
			value = map.get(key);

			for (String field : Fields) {
				if (key.equals(field)) {
					result.put(key, value);
					break;
				}

			}

		}

		System.out.println(result);
		return result;

	}

}
