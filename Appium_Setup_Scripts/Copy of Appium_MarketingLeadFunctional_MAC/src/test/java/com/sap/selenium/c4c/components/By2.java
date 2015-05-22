package com.sap.selenium.c4c.components;

import org.openqa.selenium.By;

public class By2 {
	/* Match any element by text */ 
	public static By text(String text) {
		return By.xpath("//*[contains(text(), '" + text + "')]");
	}
	/* Match input or text area elements by label */
	public static By label(String text) {
		return By.xpath("//*[preceding-sibling::label[1][. = '" + text + ":']]//*[self::input or self::textarea]");
	}
	/* Match input based on partial ID */
	public static By partialId(String partialID){
		return By.xpath("//*[contains(./@id, '" + partialID + "')]");
	}

	/* Match link based on partial ID */
	public static By linkByPartialId(String partialID){
		return By.xpath("//li[contains(./@id, '" + partialID + "')]");
	}	

	/* Match button based on partial ID and text*/
	public static By buttonByPartialIdAndText(String partialID, String text){
		return By.xpath("//button[contains(./@id, '" + partialID + "') and contains(text(), '" + text + "')]");
	}	

	/* Match button based on partial parent ID and text*/
	public static By datePickerTriggerByParentPartialId(String partialID){
		return By.xpath("//button[parent::*[starts-with(./@id, '"+ partialID + "') and contains(./@id, 'CALENDA')]]");
	}	

	/* Match with starting text and partial match ID*/	
	public static By startsWithAndPartialId(String startsWith, String partialID){
		return By.xpath("//*[starts-with(./@id, '"+ startsWith + "') and contains(./@id, '" + partialID + "')]");
	}	

	/* Match link based on partial ID */
	public static By textareaByPartialId(String partialID){
		return By.xpath("//textarea[contains(./@id, '" + partialID + "')]");
	}

	/* Match input or text area elements by label */
	public static By elementbylabelwithElementTypeandPartialID(String text, String elementType, String partialID) {
		return By.xpath("//*[preceding-sibling::label[1][. = '" + text + ":']]//*[self::" + elementType + "[contains(./@id, '" + partialID + "')]]");
	}

	/* Match link based on text */
	public static By linkByText(String text){
		return By.xpath("//a[text()=" + text +"]");
	}	

	/* Match with starting text and label text*/	
	public static By startsWithAndLabelText(String startsWith, String text){
		return By.xpath("//*[starts-with(./@id, '"+ startsWith + "') and contains(text(), '" + text + "')]");
	}


	public static By className(String classname){
		return By.className(classname);	

	}

	public static By linkText(String linkname){
		return By.linkText(linkname);
	}

	public static By partialLinkText(String linkText){
		return By.partialLinkText(linkText);		

	}

	public static By buttonByClassAndPartialId(String classID,String partialID ){
        return By.xpath("//button[@class= '" + classID + "' and contains(./@id, '" + partialID + "')]");  //  return By.xpath("//button[contains(./@class, '" + classID + "') and contains(./@id, '" + partialID + "')]");
	}

	public static By textContent(String text){

		return By.name(text);

	}

	/* Match Class based on partial ID */

	public static By classNameByPartialId(String partialID) {

		return By.xpath("//*[contains(./@class, '" + partialID + "')]");

	}


	/* Match Class and ID based on partial ID */

	public static By ByclassNameandPartialId(String classPartialID, String idPartialID) {

		return By.xpath("//*[contains(./@class, '" + classPartialID	+ "') and contains(./@id, '" + idPartialID + "')]");

	}
	
	/* eLEMENT BY xPATH */

    public static By Xpath(String xpath) {

           return By.xpath(xpath);

    }

    /* eLEMENT BY CssPath */

	public static By CssPath(String cssPath) {

		return By.cssSelector(cssPath);

	}



}
