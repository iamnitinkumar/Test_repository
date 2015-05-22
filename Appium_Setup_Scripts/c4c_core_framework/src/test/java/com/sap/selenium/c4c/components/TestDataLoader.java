package com.sap.selenium.c4c.components;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;



import java.util.Map;

//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.ss.usermodel.*;

public class TestDataLoader {

	/*protected String getDataFromCell(Iterator<Cell> cellIterator)
	{
		if(cellIterator.hasNext())
		{
			Cell cell = cellIterator.next();
			switch(cell.getCellType())
			{
				case Cell.CELL_TYPE_STRING:
					return cell.getStringCellValue().trim();
				case Cell.CELL_TYPE_NUMERIC:
					return String.valueOf(cell.getNumericCellValue());
			}
		}

		return null;

	}*/

	/**
	 * Checks if file for given full filename (path + name) exists 
	 * File is accessed via the getResource method, has to be in the project
	 * During build, file will be copied into the bin folder
	 * @param fullFileName filename + path (package + folder + name)
	 * @return true if file exists, false if not
	 */
	/*public boolean doesFileExist(String fullFileName)
	{
	    if (TestDataLoader.class.getClassLoader().getResource(fullFileName) == null)
	    	return false;
	    else
	    	return true;
	}*/

	/**
	 * File is accessed via the getResource method, has to be in the project
	 * During build, file will be copied into the bin folder
	 * 
	 * First row is the header row containing the IDs/field name
	 * Following rows are the data rows
	 * The header row determines the number of map entries (name/value pairs), missing data cells will be set to an empty string
	 * @param fullFileName filename + path (package + folder + name)
	 * @return map of maps - one name/value pair map per data row
	 */
	/*public Map<String, Map<String, String>> readExcelDataRows(String fileName, int sheetNumber)
	{
		Map<String, Map<String, String>>testDataMaps = new LinkedHashMap<String, Map<String, String>>();
		
		try
		{   
			
		    
		    URL url = TestDataLoader.class.getClassLoader().getResource(fileName);
		    
		    if (url == null)
		    	throw new FileNotFoundException();

		    FileInputStream fis = new FileInputStream(url.getPath());
			Workbook workbook = new XSSFWorkbook(fis);


			//Only specified sheet is considered, others are ignored!!!
			Sheet sheet = workbook.getSheetAt(sheetNumber);

			Iterator<Row> rowIterator = sheet.iterator();
			
			//Get field names/ids contained in first row
			Row headerRow;
			int mapCounter = 1;
			if (rowIterator.hasNext())
			{
				headerRow = rowIterator.next();
			
			
				//Get the data rows
				while(rowIterator.hasNext())
				{   
					Map<String, String>testDataMap = new LinkedHashMap<String, String>();
					String name;
					String value;
					
					Row dataRow = rowIterator.next();

					Iterator<Cell> headerCellIterator = headerRow.cellIterator();
					Iterator<Cell> dataCellIterator   = dataRow.cellIterator();
					//Process name

					//The header row determines the number of map entries, missing data cells will be set to an empty string
					while(headerCellIterator.hasNext())
					{
						name = this.getDataFromCell(headerCellIterator);
						if (dataCellIterator.hasNext())
							value = this.getDataFromCell(dataCellIterator);
						else
							value = "";

						testDataMap.put(name, value);
					}
					testDataMaps.put("TestDataMap"+mapCounter++, testDataMap);
				}
			}
			

			fis.close();

			
		}catch (IOException e){

			e.printStackTrace();
		}


		return testDataMaps;*/
	}

	
	
	/**
	 * File is accessed via the getResource method, has to be in the project
	 * During build, file will be copied into the bin folder
	 * @param fullFileName filename + path (package + folder + name)
	 * @return
	
	/*public Map<String, String> readSingleExcelSheet(String fullFileName)                        //(String path)
	{
		//List<TestData> testDataList = new ArrayList<TestData>();
		Map<String, String>testDataList = new LinkedHashMap<String, String>();
		try
		{   
			FileInputStream fis;
		    
		    URL url = TestDataLoader.class.getClassLoader().getResource(fullFileName);
		    
		    if (url == null)
		    	throw new FileNotFoundException();
		    
		    System.out.println("Full filename: "+url.getPath());
		    
			fis = new FileInputStream(url.getPath());

			Workbook workbook = new XSSFWorkbook(fis);


			//Only first sheet is considered, others are ignored!!!
			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext())
			{   
				String name = "";
				Row row = rowIterator.next();

				Iterator<Cell> cellIterator = row.cellIterator();
				//Process name

				name = this.getDataFromCell(cellIterator);
				if (name!=null)
				{
					testDataList.put(name, this.getDataFromCell(cellIterator));
				}
			}


			fis.close();
		}catch (IOException e){

			e.printStackTrace();
		}
		return testDataList;
	}*/
	 
	

