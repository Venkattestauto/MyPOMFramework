package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.Util.ElementUtil;

public class LoginPage extends BasePage  {
	
	WebDriver driver;
	ElementUtil elementUtil;
	//define locators  /OR(Object Repository)  -- with By locator (NPF pattern  -- Non Page Factory):
	
	By email  = By.id("username");
	By password  = By.id("password");
	By loginButton  = By.id("loginBtn");
	
	//constructor of  page  class:
	public LoginPage(WebDriver driver){
		   this .driver = driver;
		   elementUtil = new ElementUtil(driver);
	}
	
	//page actions:
	public String getLoginPageTitle(){ 
		 return elementUtil.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
		
	}
    
	public HomePage doLogin(String username, String pwd){
//		   driver.findElement(email).sendKeys(username); -- no nee all these we will be using elementUtil
//		   driver.findElement(password).sendKeys(pwd);
//		   driver.findElement(loginButton).click();
		   
		   elementUtil.doSendKeys(email, username);
           elementUtil.doSendKeys(password, pwd);	
           elementUtil.doClick(loginButton);
           
		   return new HomePage(driver);
	}
	
}
