package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.Util.ElementUtil;
/**
 * 
 * @author venka
 *
 */
public class ContactsPage {
	   WebDriver driver;
	   ElementUtil elementUtil;
    

	
	   By createContactButton = By.xpath("//span[text()='Create contact']");
	   By createContactFormButton  = By.xpath("//li//span[text()='Create contact']");
	   By email = By.xpath("//input[@data-field ='email']");
	   By firstName = By.xpath("//input[@data-field ='firstname']");
	   By lastName = By.xpath("//input[@data-field ='lastname']");
	   By jobTitle = By.xpath("//input[@data-field ='jobtitle']");

	   public ContactsPage(WebDriver driver){
		   this .driver = driver;
		   elementUtil = new ElementUtil(driver);
	   }
	   
	   public String getContactsPageTitle(){
		   return elementUtil.waitForPageTitle(Constants.CONTACTS_PAGE_TITLE);
	   }
	
	  //need to create By locator Contacts Page Header
	   
	   public void createNewContact(String  emailID,  String  FN,   String  LN,  String  jobTitleVal ) {
		   
		   elementUtil.doClick(createContactButton);
		   elementUtil.doSendKeys(email, emailID);
		   elementUtil.doSendKeys(firstName, FN);
		   elementUtil.doSendKeys(lastName, LN);
		   elementUtil.doSendKeys(jobTitle,  jobTitleVal);
		  
		   elementUtil.doClick(createContactFormButton);
		   	   
	   }
	   
	
	
	
	
	
}
