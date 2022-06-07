package com.InetBanking.testCases;
import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.InetBanking.pageObjects.LoginPage;
import com.InetBanking.utilities.XLUtils;

@Test(dataProvider="LoginData")

public class TC_LoginDDT_002 extends BaseClass{
	static int i=1;	
	public static void loginDDT(String uname,String pwd) throws InterruptedException, IOException {
		System.out.println("Case "+ i++ +":");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("UserName Loaded");
		lp.setUserPassword(pwd);
		logger.info("Password Loaded");
		lp.clickSubmit();
		logger.info("Login_button click");
		if(isAlertPresent()==true) {
			
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			System.out.println(driver.getCurrentUrl());
				if(driver.getCurrentUrl().contentEquals("hhttps://www.flipkart.com/"))
			{
						logger.info("Logged in successfully");
				lp.logout();
			}
			else
			{  
				logger.info("Login unsuccessful due to invalid credentials");
				captureScreen(driver,"loginTestfails");			
			}	
		}
		
//		else {
//			String url= driver.getCurrentUrl();
//			Assert.assertEquals(url, "http://demo.guru99.com/v4/manager/Managerhomepage.php");
//			logger.info("Logged in successful with valid credentials");
//			lp.logout();
//			driver.switchTo().alert().accept();
//			driver.switchTo().defaultContent(); 
//			logger.info("Logged out successfully");
//		}		
	}
		
	
	public static boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		System.out.println("inside alert");
		return true;
		}
		catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    } 
	}
		
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		
	String path=System.getProperty("user.dir")+	"/src/test/java/com/InetBanking/testData/LoginData.xlsx";
	int rownum=XLUtils.getRowCount(path,"Sheet1");
	int colcount=XLUtils.getCellCount(path,"Sheet1",1);
	String logindata[][]=new String [rownum][colcount];
	
	for(int i=1;i<=rownum;i++) {
		for(int j=0;j<colcount;j++) {
			
			logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i, j);
			
		}
	}
	  return logindata;
	
	}

}
