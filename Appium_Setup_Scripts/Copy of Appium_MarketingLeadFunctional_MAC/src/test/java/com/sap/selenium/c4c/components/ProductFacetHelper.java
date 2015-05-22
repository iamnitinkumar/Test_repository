package com.sap.selenium.c4c.components;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class ProductFacetHelper {

	private Map<String, String> OportunityFacetIdsData;
	private Map<String, String> SalesLeadFacetIdsData; 
	private Map<String, String> MarketingLeadFacetIdsData;
	private String value;
	private WebDriver webDriver;

	// Opportunity object - Product facet id's
	private final String OPPORTUNITY_PRODUCTFACET_PRODUCT_ID = "objectvalueselectormefgisGqrqIeuQOg1vg";
	private final String OPPORTUNITY_PRODUCTFACET_QUANTITY = "inputfieldm_sxhvBsiQqMVO7hhihuAQm";
	private final String OPPORTUNITY_PRODUCTFACET_QUANTITY_UNIT = "dropdownlistboxbkdgb1Gozq_EWnKsJZx_sPm";
	private final String OPPORTUNITY_PRODUCTFACET_NEGOTIATED_VALUE = "inputfieldARuxHTMweqw3ydSaW3PKoW";
	private final String OPPORTUNITY_PRODUCTFACET_START_DATE = "inputfield4uivTNK12KYoft3vmzim9m";
	private final String OPPORTUNITY_PRODUCTFACET_END_DATE = "inputfieldAl78ZKuiIKoB6jIBTIe";
	private final String OPPORTUNITY_PRODUCTFACET_NOTES = "__area";

	private String[] Fields = new String[] { "product_ID", "product_Category",
			"product_Quantity", "product_Description", "product_Notes",
			"product_Quantity_Unit", "product_StartDate",
			"product_NegotiatedValue", "product_EndDate" };

	{

		// Link Opportunity product facet ID's

		OportunityFacetIdsData = new LinkedHashMap<String, String>();

		OportunityFacetIdsData.put("product_ID",
				this.OPPORTUNITY_PRODUCTFACET_PRODUCT_ID);
		OportunityFacetIdsData.put("product_Quantity",
				this.OPPORTUNITY_PRODUCTFACET_QUANTITY);
		OportunityFacetIdsData.put("product_Quantity_Unit",
				this.OPPORTUNITY_PRODUCTFACET_QUANTITY_UNIT);
		OportunityFacetIdsData.put("product_StartDate",
				this.OPPORTUNITY_PRODUCTFACET_START_DATE);
		OportunityFacetIdsData.put("product_NegotiatedValue",
				this.OPPORTUNITY_PRODUCTFACET_NEGOTIATED_VALUE);
		OportunityFacetIdsData.put("product_EndDate",
				this.OPPORTUNITY_PRODUCTFACET_END_DATE);
		OportunityFacetIdsData.put("product_Notes",
				this.OPPORTUNITY_PRODUCTFACET_NOTES);

		// Link Sales Lead product facet ID's
		SalesLeadFacetIdsData = new LinkedHashMap<String, String>();

		SalesLeadFacetIdsData.put("product_ID",
				"objectvalueselectorO8XQrHaxX4kpiXi4iDlmuW");
		SalesLeadFacetIdsData.put("product_Category",
				"objectvalueselectorOV2feKd12a2TQIxCjHktK0");
		SalesLeadFacetIdsData.put("product_Quantity",
				"inputfieldlQ4EMT_7z4U0oC5lRRTNcG");

		// Link MarketingLead product facet ID's
		MarketingLeadFacetIdsData = new LinkedHashMap<String, String>();

		MarketingLeadFacetIdsData.put("product_ID",
				"objectvalueselector7aohD8JFBKAqytHgrDgoY0");
		MarketingLeadFacetIdsData.put("product_Category",
				"objectvalueselector_sAZL3I2ie46oZLEgRt6FaW");
		MarketingLeadFacetIdsData.put("product_Quantity",
				"inputfieldH6Pf7pzqVqwLygPAMQwL1W");
		MarketingLeadFacetIdsData.put("product_Quantity_Unit",
				"dropdownlistboxtd8ZDxqxVqwHyziC07nVgG");

	}

	public ProductFacetHelper(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void Check(String TiName) {

		switch (TiName) {
		case "Saleslead":

			new ProductFacet(this.webDriver)
					.demo(Compare(SalesLeadFacetIdsData));

			break;
		case "Opportunity":
			new ProductFacet(this.webDriver)
					.demo(Compare(OportunityFacetIdsData));

			break;
		case "MarketingLead":
			new ProductFacet(this.webDriver)
					.demo(Compare(MarketingLeadFacetIdsData));

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
