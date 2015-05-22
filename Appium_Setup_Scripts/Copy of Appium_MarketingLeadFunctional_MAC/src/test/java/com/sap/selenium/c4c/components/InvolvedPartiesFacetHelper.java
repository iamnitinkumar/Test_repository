package com.sap.selenium.c4c.components;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class InvolvedPartiesFacetHelper {

	private Map<String, String> OportunityFacetIdsData;
	private Map<String, String> SalesLeadFacetIdsData;	
	private Map<String, String> MarketingLeadLeadFacetIdsData;
	
	private String value;
	private WebDriver webDriver;
	
	//Opportunity object - Involved party facet id's
	private final String OPPORTUNITY_INVOLVEDPARTY_ROLE = "dropdownlistboxfg2ukysfcqIbOnAXIHXi0G";
	private final String OPPORTUNITY_INVOLVEDPARTY_NAME = "objectvalueselectorFwzVBBs6w4MKacLEtJHFIm"; // ButtonValueHelp
	private final String OPPORTUNITY_INVOLVEDPARTY_PRIMARY = "checkbox_s_sRO4oqISaAqk1IEilX230";
	private final String OPPORTUNITY_INVOLVEDPARTY_PRIMARY_CONTACT = "objectvalueselectorGgJyQd8CGq_LFZ_k3QZE5G";
	
	
	//Sales Lead object - Involved party facet id's
	private  final String SALESLEAD_INVOLVEDPARTY_ROLE = "dropdownlistboxpQnVkrT1XqEZAJjQ9p5jfG";
	private  final String SALESLEAD_INVOLVEDPARTY_NAME = "objectvalueselectorQdc3xaUsGaYaLsWHaFpcIG"; // ButtonValueHelp
	private  final String SALESLEAD_INVOLVEDPARTY_PRIMARY = "checkboxiHjkWJvzi4syxNSEqLVx";
	private  final String SALESLEAD_INVOLVEDPARTY_PRIMARY_CONTACT = "objectvalueselector3_5qtsXKm4MrG0ZkmlAiOm";
			
	//MarketingLead Lead object - Involved party facet id's
	private  final String MARKETINGLEAD_INVOLVEDPARTY_ROLE = "dropdownlistboxMEsJJLl9hqoLNWQReloueG";
	private  final String MARKETINGLEAD_INVOLVEDPARTY_NAME = "objectvalueselector6QQM03r2Q4A_vXJTYBtxiW"; // ButtonValueHelp
	private  final String MARKETINGLEAD_INVOLVEDPARTY_PRIMARY = "checkboxybDPZbswmqkxPRcjdnK7Vm";
	private  final String MARKETINGLEAD_INVOLVEDPARTY_PRIMARY_CONTACT = "objectvalueselectorrxApHmXf4qsTVcohKITUIW";

	

	private String[] Fields = new String[] { "Role", "Name",
			"Primary", "Primary_Contact"};

	{

		//Link Opportunity product facet ID's 
		OportunityFacetIdsData = new LinkedHashMap<String, String>();

		OportunityFacetIdsData.put("Role", this.OPPORTUNITY_INVOLVEDPARTY_ROLE);
		OportunityFacetIdsData.put("Name", this.OPPORTUNITY_INVOLVEDPARTY_NAME);
		OportunityFacetIdsData.put("Primary", this.OPPORTUNITY_INVOLVEDPARTY_PRIMARY);
		OportunityFacetIdsData.put("Primary_Contact", this.OPPORTUNITY_INVOLVEDPARTY_PRIMARY_CONTACT);


		//Link Sales Lead product facet ID's 
		SalesLeadFacetIdsData = new LinkedHashMap<String, String>();

		SalesLeadFacetIdsData.put("Role",this.SALESLEAD_INVOLVEDPARTY_ROLE );
		SalesLeadFacetIdsData.put("Name", this.SALESLEAD_INVOLVEDPARTY_NAME);
		SalesLeadFacetIdsData.put("Primary", this.SALESLEAD_INVOLVEDPARTY_PRIMARY);
		SalesLeadFacetIdsData.put("Primary_Contact", this.SALESLEAD_INVOLVEDPARTY_PRIMARY_CONTACT);
		
		
		//Link Marketing Lead product facet ID's 
		MarketingLeadLeadFacetIdsData = new LinkedHashMap<String, String>();

		MarketingLeadLeadFacetIdsData.put("Role",this.MARKETINGLEAD_INVOLVEDPARTY_ROLE );
		MarketingLeadLeadFacetIdsData.put("Name", this.MARKETINGLEAD_INVOLVEDPARTY_NAME);
		MarketingLeadLeadFacetIdsData.put("Primary", this.MARKETINGLEAD_INVOLVEDPARTY_PRIMARY);
		MarketingLeadLeadFacetIdsData.put("Primary_Contact", this.MARKETINGLEAD_INVOLVEDPARTY_PRIMARY_CONTACT);

	}
	 
	 public InvolvedPartiesFacetHelper(WebDriver webDriver)
	 {
		 this.webDriver = webDriver;
	 }

	public void Check(String TiName) {
		
		
		switch (TiName) {
		case "Saleslead":

			new InvolvedPartiesFacet(this.webDriver).demo(Compare(SalesLeadFacetIdsData));

			break;
		case "Opportunity":
			new InvolvedPartiesFacet(this.webDriver).demo(Compare(OportunityFacetIdsData));

			break;
			
		case "MarketingLead":
			new InvolvedPartiesFacet(this.webDriver).demo(Compare(MarketingLeadLeadFacetIdsData));

			break;
		default: // Optional
			// Statements
		}
	}

	private Map<String, String> Compare(Map<String, String> map) {

		Map<String, String> result = new LinkedHashMap<String, String>();

		for (String key : map.keySet()) {
			value = map.get(key);

			for (String field : Fields) {
				if (key.equals(field)) {
					result.put(key, value);
					// System.out.println(key);
					// System.out.println(value);
					break;
				}

			}

		}

		System.out.println(result);
		return result;

	}
	
	

}
