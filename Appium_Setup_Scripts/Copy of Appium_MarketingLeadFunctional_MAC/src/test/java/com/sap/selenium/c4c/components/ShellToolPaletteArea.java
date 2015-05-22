package com.sap.selenium.c4c.components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class ShellToolPaletteArea extends Base{
	

	public ShellToolPaletteArea(WebDriver webDriver)
	{
		super(webDriver);
	}

	
	//the next two might need more matching restrictions assumes that there is always home page before search
	public void openHomePageAndMeasure(String measurementName)
	{
		//can't use navigateAndMeasure - partial ID match does not work if complete name is provided
		WebElement elem = driver.findElement(By.id("main-tool-__popup0"));  
		PerformanceRunner.startMeasurement(measurementName);
		elem.click();
		PerformanceRunner.stopMeasurement();
		
	}
	
	public void openEnterpriseSearchAndMeasure(String measurementName)
	{
		//can't use navigateAndMeasure - partial ID match does not work if complete name is provided
		WebElement elem = driver.findElement(By.id("main-tool-__popup1"));  
		PerformanceRunner.startMeasurement(measurementName);
		elem.click();
		PerformanceRunner.stopMeasurement();
	}
	
	
	public void openAccountQC() throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_ACCOUNT_TT", "Open_QC_Account");
	}
	
	public void openContactQC() throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_CONTACT_TT", "Open_QC_Contact");
	}
	
	public void openSalesLeadQC() throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_MARKETINGLEAD_", "Open_QC_SalesLead");
	}
		
	public void openMarketingLeadQC() throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_MKT_PROSPECT_", "Open_QC_MarketingLead");
	}
	
	public void openOpportunityQC() throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_OPPORTUNITY_", "Open_QC_Opportunity");
	}
	
	public void openQuoteQC() throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_QUOTE_TT", "Open_QC_Quote");
	}
	
	public void openAppointmentQC() throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_APPOINTMENT", "Open_QC_Appointment");
	}
	
	public void openPhoneCallQC() throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_PHONECALL", "Open_QC_PhoneCall");
	}
	
	public void openTaskQC() throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_TASK", "Open_QC_Task");
	}
	
	public void openVisitQC() throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_VISIT_TT", "Open_QC_Visit");
	}
	
	
	/*
	 * going to be deleted!!!!
	 */
	
	public void openAccountQCAndMeasure(String measurementName) throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_ACCOUNT_TT", "Open_QC_Account");
	}
	
	public void openContactQCAndMeasure(String measurementName) throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_CONTACT_TT", measurementName);
	}
	
	public void openSalesLeadQCAndMeasure(String measurementName) throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_MARKETINGLEAD_", measurementName);
	}
		
	public void openMarketingLeadQCAndMeasure(String measurementName) throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_MKT_PROSPECT_", measurementName);
	}
	
	public void openOpportunityQCAndMeasure(String measurementName) throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_OPPORTUNITY_", measurementName);
	}
	
	public void openQuoteQCAndMeasure(String measurementName) throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_QUOTE_TT", measurementName);
	}
	
	public void openAppointmentQCAndMeasure(String measurementName) throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_APPOINTMENT", measurementName);
	}
	
	public void openPhoneCallQCAndMeasure(String measurementName) throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_PHONECALL", measurementName);
	}
	
	public void openTaskQCAndMeasure(String measurementName) throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_TASK", measurementName);
	}
	
	public void openVisitQCAndMeasure(String measurementName) throws Exception
	{
		navigateAndMeasure("main-tool-qctoolpopupCOD_VISIT_TT", measurementName);
	}
	
	private void navigateAndMeasure(String elementName, String measurementName) throws Exception
	{		
		PerformanceRunner.startMeasurement(measurementName);
		this.elementToClick(By2.partialId(elementName), 60);
		PerformanceRunner.stopMeasurement();
	}
	
}
