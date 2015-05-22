package com.sap.selenium.c4c.scripts;

import org.openqa.selenium.WebDriver;


import com.sap.selenium.c4c.components.TaskOWL;
import com.sap.selenium.c4c.components.TaskTI;

public class TaskObj {
	
	protected WebDriver driver;
	private TaskOWL taskOWL = null;
	private TaskTI taskTI = null;
	
	public TaskObj(WebDriver webDriver)
	{
		driver = webDriver;
	}
	
	 public TaskOWL gettaskOWL()
	    {
	    	if (taskOWL == null)
	    	{
	    		taskOWL = new TaskOWL(driver);
	    	}
	    	return taskOWL;
	    }
	 
	 public TaskTI getTaskTI(){
		 
		 if (taskTI == null)
		 {
			 taskTI = new TaskTI(driver);
		 }
		 return taskTI;
	 }

}
