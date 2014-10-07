package logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.testng.Reporter;

import utils.GetData;

public class LoggerStatus {
	private static LoggerStatus instance = null;
	   public static LoggerStatus getInstance() throws ClassNotFoundException {
	      if(instance == null) {
	         instance = new LoggerStatus();
	      }
	      return instance;
	   }
	/**
	 * report_header - creates a header in the report file
	 * @param filename - report file name
	 * @throws IOException
	 */
    public void report_header(String filename) throws IOException {
    	File file =new File(filename);
        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(file,true);
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
			
            bufferedWriter.write("</tr><tr><td class=\"td1\"><strong>Test ID</strong></td>"); 
            bufferedWriter.write("<td class=\"td2\"><strong>Test Case Description</strong></td>"); 
            bufferedWriter.write("<td class=\"td3\"><strong>Result</strong></td></tr>");

            // Always close files.
            bufferedWriter.close();
            fileWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + file + "'");
        }
    }
    /**
	 * reportTitle - creates a title in the report file
	 * @param filename - report file name
	 * @throws IOException
	 */
    public void reportTitle(String filename)
    {
    	 File file =new File(filename);
    	 try {
             FileWriter fileWriter =
                 new FileWriter(file,false);
             BufferedWriter bufferedWriter =
                 new BufferedWriter(fileWriter);
	    	 bufferedWriter.write("<html>");
	         bufferedWriter.write("<head><title>Test Automation Report</title><style type=\"text/css\">");
	         bufferedWriter.write("body {background-color: #FFFFF0; font-family: \"VAG Round\" ; color : #000080}");
	         bufferedWriter.write("table {table-layout:automatic; border-color:#000000; cell-spacing:10; font-size=100%; font-family:\"Calibri\"}.td1 {width: 3%; text-align: center}");
	         bufferedWriter.write(".td2 {width: 20%}");
	         bufferedWriter.write(".td3 {width: 15%}</style></head>");
	         bufferedWriter.write("<body><center>");
	         bufferedWriter.write("<h1><u>Test Automation Report</u></h1><br /><center><table border=2 width=\"900px\">");
	         bufferedWriter.write("<col span=\"2\" /><col />"); 
	         bufferedWriter.write("<tr>"); 
	         bufferedWriter.write("<th colspan=\"3\" align=\"left\">");
	         // Always close files.
	         bufferedWriter.close();
	         fileWriter.close();
    	 }
    	 catch(IOException ex) {
    		 Reporter.log("Error writing to file '" + file + "'",true);
    	 }
    }
    /**
     * report_testcasedescription - Creates a description for scenario in report file
     * @param filename -  report file name
     * @param testScenarioCount - count of scenario
     * @param test_description - description of the scenario
     * @throws IOException
     */
    public void report_testcasedescription(String filename,String testScenarioCount, String test_description) throws IOException {
    	File file =new File(filename);
        try {
            FileWriter fileWriter =
                new FileWriter(file,true);
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            bufferedWriter.write("<col span=\"2\" /><col />"); 
            bufferedWriter.write("<tr>"); 
            bufferedWriter.write("<th colspan=\"3\" align=\"left\">");
            
            bufferedWriter.write("<font align=\"left\">"+testScenarioCount+": "+test_description+"</font></th>");

            // Always close files.
            bufferedWriter.close();
            fileWriter.close();
        }
        catch(IOException ex) {
        	 Reporter.log("Error writing to file '" + file + "'",true);
        }
    }
    
    /**
     * report_results - reports the status of the test case run
     * @param filename - report file name
     * @param id - test case id
     * @param testname - name of the test case
     * @param result - status of test run
     */
    public void report_results(String filename,int id, String testname, String result){
    	try{
    		File file =new File(filename);
    		FileWriter fileWritter = new FileWriter(file.getAbsoluteFile(),true);
	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	        bufferWritter.write("<tr><td class=\"td1\">"+id+"</td>");
	        bufferWritter.write("<td class=\"td2\">"+testname+"</td>");
	        bufferWritter.write("<td class=\"td3\"><font color"+result+"/font></td></tr>");
	        bufferWritter.close();
	        fileWritter.close();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	
    }
    /**
     * report_summary - Creates a summary for test run
     * @param filename - report file name
     * @param time - total execution time
     * @throws ClassNotFoundException
     */
    public void report_summary(String filename,String time) throws ClassNotFoundException{
    	 String content="";
    	try{
    		//String data = " This content will append to the end of the file";
    		
    		File file =new File(filename);
    		try{
 	    	   FileReader fr=new FileReader(filename);
 	    	   @SuppressWarnings("resource")
 	    	   BufferedReader br= new BufferedReader(fr);
 	    	  
 	    	   String s;
 			   while((s=br.readLine())!=null)
 	    	   {
 	    	     content=content+s;
 	    	    } 

     	   }
     	   catch(Exception ex)
     	   {
     		 Reporter.log( "Error reading from the file '" + file + "'");
     	    }
    		
    		FileWriter fileWritter = new FileWriter(file.getAbsoluteFile(),false);
    	    BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	    
			bufferWritter.write("<html>");
	        bufferWritter.write("<body><center>");
	        bufferWritter.write("<h1><u>Test Automation Summary</u></h1><br /><center><table border=2 width=\"500px\">");
	        bufferWritter.write("<tr><td class=\"td2\"><font color=\"green\">Test Cases Scenarios Passed:</td>");
	        bufferWritter.write("<td class=\"td3\">"+GetData.getInstance().sCount+"</td>");
	        bufferWritter.write("<tr><td class=\"td2\"><font color=\"Red\">Test Cases Scenarios Failed:</td>");
	        bufferWritter.write("<td class=\"td3\">"+GetData.getInstance().fCount+"</td>");
	        bufferWritter.write("<tr><td class=\"td2\"><font color=\"green\">Test Cases Passed:</td>");
	        bufferWritter.write("<td class=\"td3\">"+GetData.successCounter+"</td>");
	        bufferWritter.write("<tr><td class=\"td2\"><font color=\"Red\">Test Cases Failed:</td>");
	        bufferWritter.write("<td class=\"td3\">"+GetData.failureCounter+"</td>");
	        bufferWritter.write("<tr><td class=\"td2\"><font color=\"Black\">Total Execution time:</td>");
	        bufferWritter.write("<td class=\"td3\">"+time +"</td>");
	        bufferWritter.write("</tr></table></center>");
	        bufferWritter.write(content);
	        //bufferWritter.write(fileContents);
	        bufferWritter.write("</body></html>");
	        
	        bufferWritter.close();
	        fileWritter.close();	        
	         
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	
    }
    /**
     * updateLogfile - Updates the log file with the specified text
     * @param filename - log file name
     * @param text - content to be written to the file
     * @param flag - append/overwrite flag
     * @throws IOException
     */
    public void updateLogfile(String filename,String text, boolean flag) throws IOException {

    	File file =new File(filename);
        try {
            FileWriter fileWriter =
                new FileWriter(file,flag);
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
			bufferedWriter.write(text);
			bufferedWriter.close();
            fileWriter.close();
        }
        catch(IOException ex) {
            Reporter.log("Error writing to file '"+ file + "'",true);
        }
    }
	
}