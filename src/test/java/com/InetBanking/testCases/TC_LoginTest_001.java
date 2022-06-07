package com.InetBanking.testCases;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import com.InetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	

	@Test
	public void LogicTest() throws IOException, InterruptedException {
		

	LoginPage lp=new LoginPage(driver);
    logger.info("Page Loaded ");
	
	
	lp.setUserName(userName);
    logger.info("UserName Loaded");
    
	lp.setUserPassword(password);
	logger.info("Password Loaded");
	
	lp.clickSubmit();
	logger.info("login_button clicked");
	
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
	{
		AssertJUnit.assertTrue(true);
		logger.info("Login sucesfully");
		
	}
	else
	{  
		AssertJUnit.assertTrue(false);
		logger.info("Login unsucesfull ");
		captureScreen(driver,"loginTestfails");
		
		
	}
	
		
		
		
	}
	

}
