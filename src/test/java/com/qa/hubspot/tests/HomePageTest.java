package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class HomePageTest {

	
	WebDriver driver;
    Properties prop;
    BasePage  basePage;
    LoginPage  loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setup(){
   	   basePage   =  new  BasePage();
   	   prop = basePage.initialize_properties();
   	   driver  = basePage.initialize_driver(prop);
   	   loginPage  = new LoginPage(driver);
   	   homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
   	   
   	   
   	   // The below explicit wait is not required as we have already used webdriverwait in element util class
   	   /*try {
		Thread.sleep(8000);
	} catch (InterruptedException e) {
			e.printStackTrace();
	}*/
   	   	    	 
    }
	
	@Test(priority =1)
	public void verifyHomePageTitleTest(){
		String title =homePage.getHomePageTitle();
		System.out.println("home page title  is:  "+title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
		
	}
	
	@Test(priority =2)
	public void verifyHomePageHeaderTest(){
		String headerValue = homePage.getHomePageHeaderValue();
		System.out.println("home page header is:  "+headerValue);
		Assert.assertEquals(headerValue, Constants.HOME_PAGE_HEADER);
	}
	
    @Test(priority =3)
    public void verifyLoggedInUserAccountTest(){
    	String accountName =homePage.getLoggedInAccountName();
    	System.out.println("logged in account name is:  "+accountName);
    	Assert.assertTrue(homePage.verifyLoggedInAccountName());
       	Assert.assertEquals(accountName, prop.getProperty("accountname"));
       	
    	
    }
    
    
    
    
    
    @AfterMethod
    public void teardown(){
   	 driver.quit();
    }
	
	
	
	
	
}
