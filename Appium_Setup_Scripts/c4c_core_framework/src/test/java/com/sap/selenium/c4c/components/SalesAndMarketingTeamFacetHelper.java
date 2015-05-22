package com.sap.selenium.c4c.components;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class SalesAndMarketingTeamFacetHelper {

	private Map<String, String> OportunityFacetIdsData;
	private Map<String, String> SalesLeadFacetIdsData;
	private Map<String, String> MarketingLeadFacetIdsData;
	private String value;
	private WebDriver webDriver;
	
	//Opportunity object - sales team facet id's
		private final String OPPORTUNITY_SALESTEAMFACET_ROLE = "dropdownlistboxSt1vWbkqU4gF7fti9m602m"; 
		private final String OPPORTUNITY_SALESTEAMFACET_NAME = "objectvalueselectorlURHCqhaXqA3UzTwBXKGGm"; // ButtonValueHelp

	

	private String[] Fields = new String[] { "salesAndMarketingLead_Role",
			"salesAndMarketingLead_Name", "salesAndMarketingLead_Primary" };

	{
		
				OportunityFacetIdsData = new LinkedHashMap<String, String>();
				OportunityFacetIdsData.put("salesAndMarketingLead_Role", this.OPPORTUNITY_SALESTEAMFACET_ROLE);
				OportunityFacetIdsData.put("salesAndMarketingLead_Name", this.OPPORTUNITY_SALESTEAMFACET_NAME);
		
		
		
				SalesLeadFacetIdsData = new LinkedHashMap<String, String>();
				SalesLeadFacetIdsData.put("salesAndMarketingLead_Role","dropdownlistbox_sr2yI6BFeqkcmt384onkMm");
				SalesLeadFacetIdsData.put("salesAndMarketingLead_Name","objectvalueselectorQdc3xaUsGaYaLsWHaFpcIG");
				SalesLeadFacetIdsData.put("salesAndMarketingLead_Primary","checkboxMuMuLGVmxqATMUBse");
				
				
				MarketingLeadFacetIdsData = new LinkedHashMap<String, String>();
				MarketingLeadFacetIdsData.put("salesAndMarketingLead_Role","dropdownlistboxqxNPQ_BisaI7Y7pXMLiUS0");
				MarketingLeadFacetIdsData.put("salesAndMarketingLead_Name","objectvalueselector7rVnOj04iq6kRdgA10tKWW");
				MarketingLeadFacetIdsData.put("salesAndMarketingLead_Primary","checkbox50h9S6eywqwlQ1s9YQuduW");
		


	}
	
	 public SalesAndMarketingTeamFacetHelper(WebDriver webDriver)
	 {
		 this.webDriver = webDriver;
	 }
	 
	public  void Check(String TiName) {

		switch (TiName) {
		case "Saleslead":

			new SalesAndMarketingTeamFacet(this.webDriver).demo(Compare(SalesLeadFacetIdsData));

			break;
		case "Opportunity":

			new SalesAndMarketingTeamFacet(this.webDriver).demo(Compare(OportunityFacetIdsData));

			break;
		case "MarketingLead":

			new SalesAndMarketingTeamFacet(this.webDriver).demo(Compare(MarketingLeadFacetIdsData));

			break;
		default: // Optional
			// Statements
		}
	}

	public  Map<String, String> Compare(Map<String, String> map) {

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
