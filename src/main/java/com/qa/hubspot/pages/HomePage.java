package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.Util.ElementUtil;

public class HomePage extends BasePage {
	
	      WebDriver driver;
	      ElementUtil elementUtil;
	      
	      By header  = By.cssSelector("h1.private-header__heading>i18n-string");
	      By accountName = By.cssSelector("a#account-menu>span.account-name ");
	      
	      By contactsMainTab = By.id("nav-primary-contacts-branch");
	      By contactsChildTab = By.id("nav-secondary-contacts");
	      
	      
	      public HomePage(WebDriver driver){
	    	  this.driver = driver;  
	    	  elementUtil = new ElementUtil(driver);
	      }
	
	      public String getHomePageTitle(){
	    	        //return driver.getTitle();
	    	        return elementUtil.waitForPageTitle(Constants.HOME_PAGE_TITLE);
	    	        
	      }
	
	      public String getHomePageHeaderValue(){
	    	   //return driver.findElement(header).getText();
	    	  return elementUtil.doGetText(header);
	      }
	
	     public boolean verifyLoggedInAccountName(){
	    	 //return driver.findElement(accountName).isDisplayed();
	    	 //return elementUtil.getElement(accountName).isDisplayed();   // one way 
	    	 return elementUtil.isElementDisplayed(accountName);// using--  by creating utility for isDisplayed 
	     }
	     
	     public String getLoggedInAccountName(){
	    	 //return driver.findElement(accountName).getText();
	    	 return elementUtil.doGetText(accountName);
	    	 
	     }
	
	     public void clickOnContacts(){
	    	 elementUtil.doClick(contactsMainTab);
	    	 elementUtil.doClick(contactsChildTab);
	     }
	
	    public ContactsPage gotoContactsPage(){
	    	clickOnContacts();
	    	return new ContactsPage(driver);
	    }
	

}
