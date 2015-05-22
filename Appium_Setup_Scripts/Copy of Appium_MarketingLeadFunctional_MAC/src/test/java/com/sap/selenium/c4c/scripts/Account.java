package com.sap.selenium.c4c.scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.sap.selenium.c4c.components.AccountOWL;
import com.sap.selenium.c4c.components.AccountQC;
import com.sap.selenium.c4c.components.AccountTI;

import org.junit.Assert;

public class Account {

	private WebDriver driver;
	private AccountTI accountTI = null;
	private AccountOWL accountOWL = null;
	private AccountQC accountQC = null;

	
	public Account(WebDriver webDriver)
	{
		
		driver = webDriver;
	}
	
    /*
     * New TI, OWL classes
     */
    public AccountTI getAccountTI()
    {
    	if (accountTI == null)
    	{
    		accountTI = new AccountTI(driver);
    	}
    	return accountTI;
    }

    
    public AccountOWL getAccountOWL()
    {
    	if (accountOWL == null)
    	{
    		accountOWL = new AccountOWL(driver);
    	}
    	return accountOWL;
    }

    
    public AccountQC getAccountQC()
    {
    	if (accountQC == null)
    	{
    		accountQC = new AccountQC(driver);
    	}
    	return accountQC;
    }
    
    
    /**
     *Add Sales Lead to an existing account and it requires two parameters
     * @param accountName This paramater is used to pass the name of the account that will be searched using simple search
     * @param data This is a value pair that will contain all the values to populate the Quick Create of Lead
     * @return
     */
    
   public Boolean editAccountToAddSalesLead(String accountName, Map<String, String> data)
   {
		try {
			this.getAccountOWL().openTIFromSimpleSearchWithFilter(accountName, AccountOWL.SIMPLE_SEARCH_FILTER_ALL);
		} catch (Exception e) {
			Assert.fail("Opening account failed: "+ e.getLocalizedMessage());  
			//e1.printStackTrace();
		}
		
		
		try {
			this.getAccountTI().changeTabToSalesLeads();;
		} catch (Exception e) {
			Assert.fail("Navigation to sales leads failed: "+ e.getLocalizedMessage()); 
		}
		
		
		try {
			this.getAccountTI().newSalesLead(data);;
		} catch (Exception e) {
			Assert.fail("Sales lead creation failed: "+ e.getLocalizedMessage()); 
		}
		

		//Adding does not switch account into change mode, no need to save!
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	
	   return true;
   }
   
   /**
    * This method closes the TI for account
    * @return
    */
    
   
   public Boolean closeAccount()
   {
		
		
		try {
			this.getAccountTI().close();
			
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	   return true;
   }
   
  
   /**
    * This method is used to create accounts from the toolbar. It requires two parameters 
    * @param data This paramater is used to past the value pairs of all the fields that will be populated within the Quick Create
    * @param afterAction this parameter is used to determine the type of saving that will be done, by example Save only, Save and Open or Save and New
    * @return
    */
   
   
   public Boolean createAccountFromToolBar(Map<String, String> data, String afterAction)
   {
	   
	     try {
	    	this.getAccountQC().qcFromToolBar();
	    	Thread.sleep(3000);
	    	switch(afterAction)
	    	{
	    	case "SAVE":
	    		this.getAccountQC().createAndSave(data);
	    		break;
	    	case "OPEN":
	    		this.getAccountQC().createAndOpen(data);
	    		break;
	    	case "NEW":
	    		this.getAccountQC().createAndNew(data);
	    		break;
	    	}
	    	Thread.sleep(10000);	
		} catch (Exception e) {
			Assert.fail("Account creation failed: "+ e.getLocalizedMessage()); 
		}
	    Assert.assertTrue("Account create successful", true);
	    return true;
   }
   
   /**
    * This method creates a new account from the New link on the OWL screen. This method requires two parameters: 
    * @param data Pair values for all the fields that will be populated in the Quick Create
    * @param afterAction Action for Save, there are two options SAVE which will only Save the account or OPEN that will do a Save & Open
    * @return
    */
   
   public Boolean createAccountFromNew(Map<String, String> data, String afterAction)
   {
	   
	     try {
	    	this.getAccountOWL().navigate();
	    	this.getAccountQC().createFromNew("ACCOUNT");
	    	Thread.sleep(3000);
	    	switch(afterAction)
	    	{
	    	case "SAVE":
	    		this.getAccountQC().createAndSave(data);
	    		break;
	    	case "OPEN":
	    		this.getAccountQC().createAndOpen(data);
	    		break;
	    	case "NEW":
	    		this.getAccountQC().createAndNew(data);
	    		break;
	    	
	    	}
	    	Thread.sleep(10000);
			
	     }catch (Exception e) {
			Assert.fail("Account creation failed: "+ e.getLocalizedMessage()); 
		}
	   
			
		   
		   Assert.assertTrue("Account create successful", true);
		   return true;
   }
   
   
   /**
    * This method opens an account after searching from it using the simple search, it requires two parameters:
    * @param accountName Name of the account of how it will search in the simple search and which should show in the results
    * @param filterName Filter name used for simple search, this is language dependent, like All, My Accounts, etc
    * @return
    */
   
   
   public Boolean openAccount(String accountName, String filterName)
   {
		try {
			simpleSearchAccount(accountName, filterName);
			//this.getAccountOWL().openTI(accountName);
			this.getAccountOWL().openTI(accountName);
		} catch (Exception e) {
			Assert.fail("Opening account failed: "+ e.getLocalizedMessage());
		}
	   Assert.assertTrue("Account opened successful", true);
	   return true;
   } 
   
  /**
   * This method only navigates to the Account Work Center View
   * @throws Exception
   */
   
   
   public void navigateToAccount() throws Exception{
	
	  
		   this.getAccountOWL().navigate();
	  
	
	   
	   
   }
   
   /**
    * This method opens an account after searching from it using the simple search, it requires two parameters: 
    * @param searchTerm Name of the account of how it will search in the simple search and which should show in the results
    * @param filterType Filter name used for simple search, this is language dependent, like All, My Accounts, etc
    * @return
    */
      
   public Boolean simpleSearchAccount(String searchTerm, String filterType){
	   
	   try{
		   this.getAccountOWL().openFilter(filterType);
		   this.getAccountOWL().simpleSearch(searchTerm);
		   
	   }
	   catch(Exception e){
		   Assert.fail("Failed to seach term: "+ searchTerm + " with error: " +  e.getLocalizedMessage());
	   }
	   
	   Assert.assertTrue("Account founded successful", true);
	   return true;
   }
   
   
   /**
    * This method saves account thing inspector  
    * @return
    */
   
   public Boolean saveAccount(){
	   try{
		   this.getAccountTI().clickButton("SAVE");
	   }
	   catch(Exception e){
		   Assert.fail("Failed to seach save account with error: "+  e.getLocalizedMessage());
	   }
	   
	   Assert.assertTrue("Account saved successful", true);
	   return true;
   }
   
    
   
      
   /**
    * Add Contact to an account when the account is already open
    * @param data data Pair values for all the fields that will be populated in the Quick Create for contact
    * @return
    */
   public Boolean addContact(Map<String, String> data)
   {
	   try{
		   	this.getAccountTI().changeTabToContacts();
		    this.accountTI.addContact(data);
		    System.out.println("add contact done");
	   }
   		catch (Exception e) {
		Assert.fail("Failed to add contact to account with error: "+ e.getLocalizedMessage()); 
	}
  
	   
	   Assert.assertTrue("Contact was added to account successful", true);
	   return true;

   } 
   
   /**
    * Add address to an account when the account is already open
    * @param data data Pair values for all the fields that will be populated in the Quick Create for address
    * @return
    */
   
   public Boolean addAddress(Map<String, String> data)
   {
	   try{
		   this.getAccountTI().changeTabToAddresses();
		   this.getAccountTI().addAddress(data);		   	   
		   
	   }
   		catch (Exception e) {
		Assert.fail("Failed to add address to account with error: "+ e.getLocalizedMessage()); 
	}
  
	   
	   Assert.assertTrue("Add address to account", true);
	   return true;
   }
   
   
   /**
    * This method enable the edit mode and edit the account summary section, it requires the account thing inspector to be already opened
    * @param data data Pair values for all the fields that will be populated in the account summary
    * @return
    */
   public Boolean editAccountSummary(Map<String, String> data){
	   try{		   
		   this.getAccountTI().clickButton("EDIT");
		   Thread.sleep(5000);
		   this.getAccountTI().editAccountSummary(data);
	   }
	   catch(Exception e){
		   Assert.fail("Failed to edit account with error: "+ e.getLocalizedMessage()); 
	   }
	   
	   Assert.assertTrue("Account edit successful", true);
	   return true;
   }
   
   
   /**
    * This method is used to navigate to an specific Work Center. The name of the workcenters and second level nagivation have to be provided in the language that is used for testing
    * @param owlName This paramater is the name of the Work Center or first level navigation
    * @param tabName This parameter is used to determine the second level navigation
    * @return
    * @throws Exception
    */
   public Boolean navigate(String owlName, String tabName) throws Exception{
	   try {
		this.getAccountOWL().navigateFromUser(owlName, tabName);
	} catch (Exception e) {
		Assert.fail("Failed to naviagte to WoC " + tabName+ " with error: "+ e.getLocalizedMessage()); 
	}
	   
	   Assert.assertTrue("Navigation to WoC " + tabName +" successful", true);
	   return true;
	   
	   
	   
   }

   /**
    * Create accounts based on the data in the passed file.
    * Method opens QC, enters data retrieved from file, executes save&close, creates next account if needed
    * @param fullFileName
    * @return
    */
  /* public Boolean createAccountsFromFile(String fullFileName)
   {
	   TestDataLoader tdl = new TestDataLoader();
	   ShellToolPaletteArea  toolArea = new ShellToolPaletteArea(driver);

	   if (tdl.doesFileExist(fullFileName))
	   {

		   Map<String, Map<String, String>>testDataMaps = tdl.readExcelDataRows(fullFileName, 0);

		   for (String key : testDataMaps.keySet())
		   {
			   Map<String, String> data = testDataMaps.get(key);
			   try {
				   toolArea.openAccountQC();
				   
				   try {
					   Thread.sleep(5000);
				   } catch (InterruptedException e) {
					   e.printStackTrace();
				   }
				   
				   this.getAccountQC().createAndSave(data);

			   } catch (InterruptedException e) {
				   Assert.fail("Account creation failed for set <"+key+">: "+ e.getLocalizedMessage()); 
			   }
			   try {
				   Thread.sleep(10000);
			   } catch (InterruptedException e) {
				   e.printStackTrace();
			   }
		   }
	   } 
	   else
	   {
		   Assert.fail("Account creation failed - file <"+ fullFileName + "> does not exist");
	   }

	   Assert.assertTrue("Account create successful", true);

	   return true;
   }*/
}
