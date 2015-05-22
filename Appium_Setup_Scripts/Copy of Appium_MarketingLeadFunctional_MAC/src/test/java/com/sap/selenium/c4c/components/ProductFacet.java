package com.sap.selenium.c4c.components;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.By2;

public class ProductFacet extends BaseFacet {

	protected static String Product_ID = "Product_ID";
	protected static String Product_Category = "Product_Category";
	protected static String Product_Quantity = "Product_Quantity";
	protected static String Product_Description = "Product_Description";
	protected static String Product_Notes = "Product_Notes";
	protected static String Product_Quantity_Unit = "Product_Quantity_Unit";
	protected static String Product_StartDate = "product_StartDate";
	protected static String Product_NegotiatedValue = "product_NegotiatedValue";
	protected static String Product_EndDate = "product_EndDate";

	public ProductFacet(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}


	public ProductFacet(WebDriver webDriver, String tiName, String testCaseName) {
		super(webDriver);
		new ProductFacetHelper(webDriver).Check(tiName);

		this.facetName = "Products";
		this.testName = testCaseName;

	}
	
	public static String getProduct_ID() {
		return Product_ID;
	}

	public static String getProduct_Category() {
		return Product_Category;
	}

	public static String getProduct_Quantity() {
		return Product_Quantity;
	}

	public static String getProduct_Description() {
		return Product_Description;
	}

	public static String getProduct_Notes() {
		return Product_Notes;
	}

	public static String getProduct_Quantity_Unit() {
		return Product_Quantity_Unit;
	}

	public static String getProduct_StartDate() {
		return Product_StartDate;
	}

	public static String getProduct_NegotiatedValue() {
		return Product_NegotiatedValue;
	}

	public static String getProduct_EndDate() {
		return Product_EndDate;
	}


	@Override
	protected Map<String, String> getTexts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void add(Map<String, String> data) throws Exception {
		// TODO Auto-generated method stub

		String value;
		WebElement elem;

		for (String key : data.keySet()) {
			
			Thread.sleep(2000);

			value = data.get(key);
			switch (key) {
			case "Product_ID":

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(ProductFacet.Product_ID,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog_New(ProductFacet.Product_ID, value,
							"PRODUCT", Constants.PRODUCT_VALUEHELP_TABLE_ID);
				}

				break;

			case "Product_Category":

				if ((elem = this.getElementIfExisting(By2
						.startsWithAndPartialId(ProductFacet.Product_Category,
								"ButtonValueHelp"), 1)) != null) {
					this.valueHelpDialog_New(ProductFacet.Product_Category, value,
							"CATEGORY",
							Constants.PRODUCT_CATEGORY_VALUEHELP_TABLE_ID);
				}

				break;

			case "Product_Quantity":

				if ((elem = this.getElementIfExisting(By2
						.partialId(ProductFacet.Product_Quantity), 5)) != null) {
					elem.clear();
					elem.sendKeys(value);
					elem.sendKeys(Keys.ENTER);
				}

				break;
				
			case "Product_Quantity_Unit":

				this.elementToClear(By2.partialId(ProductFacet.Product_Quantity_Unit),2);
				this.elementToSendKey(By2.partialId(ProductFacet.Product_Quantity_Unit), 1, value);
				
				break;
				
			case "Product_StartDate":

				this.elementToClear(By2.partialId(ProductFacet.Product_StartDate),2);
				this.elementToSendKey(By2.partialId(ProductFacet.Product_StartDate), 1, value);
				break;
								
			case "Product_NegotiatedValue":

				this.elementToClear(By2.partialId(ProductFacet.Product_NegotiatedValue),2);
				this.elementToSendKey(By2.partialId(ProductFacet.Product_NegotiatedValue), 1, value);
				break;
				
			case "Product_EndDate":

				this.elementToClear(By2.partialId(ProductFacet.Product_EndDate),2);
				this.elementToSendKey(By2.partialId(ProductFacet.Product_EndDate), 1, value);
				break;
			
			
			default:
				// Fill the remaining simple fields

				if ((elem = this.getElementIfExisting(By2.partialId(key), 1)) != null) {
					elem.sendKeys(value);
				} else {
					if ((elem = this.getElementIfExisting(By2.label(key), 1)) != null) {
						elem.sendKeys(value);
					}
				}

			}

		}

	}

	public void demo(Map<String, String> map) {
		String value;

		for (String key : map.keySet()) {
			value = map.get(key);
			switch (key) {

			case "product_ID":
				if (value != null) {
					Product_ID = value;
					System.out.println("Product_ID : " + Product_ID);

				}

				break;

			case "product_Category":
				if (value != null) {
					Product_Category = value;
					System.out
							.println("Product_Category : " + Product_Category);

				}

				break;

			case "product_Quantity":
				if (value != null) {
					Product_Quantity = value;
					System.out.println("Product_Quantity :" + Product_Quantity);

				}

				break;

			case "product_Description":
				if (value != null) {
					Product_Description = value;
					System.out.println("Product_Quantity :"
							+ Product_Description);
				}

				break;
			case "product_Notes":
				if (value != null) {
					Product_Notes = value;
					System.out.println("Product_Notes :" + Product_Notes);
				}
				break;
				
			case "product_Quantity_Unit":

				if (value != null) {
					Product_Quantity_Unit = value;
					System.out.println("Product_Quantity_Unit :" + Product_Quantity_Unit);
				}
				break;
						
			case "product_StartDate":

				if (value != null) {
					Product_StartDate = value;
					System.out.println("product_StartDate :" + Product_StartDate);
				}
				break;
								
			case "product_NegotiatedValue":

				if (value != null) {
					Product_NegotiatedValue = value;
					System.out.println("product_NegotiatedValue :" + Product_NegotiatedValue);
				}
				break;
				
			case "product_EndDate":


				if (value != null) {
					Product_EndDate = value;
					System.out.println("product_EndDate :" + Product_EndDate);
				}
				break;

			}

		}

	}

}
