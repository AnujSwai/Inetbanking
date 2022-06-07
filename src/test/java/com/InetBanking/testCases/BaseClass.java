package com.InetBanking.testCases;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.InetBanking.utilities.ReadConfig;

public class BaseClass  {
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getapplicationURL();
	public String userName=readconfig.getname();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	{
		logger=Logger.getLogger("e-Banking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
		driver=new ChromeDriver();
		}
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getfirefox());
			driver=new FirefoxDriver();
			}
		if(browser.equals("msEdge")) {
			System.setProperty("webdriver.edge.driver",readconfig.getmsEdge());
			driver=new EdgeDriver();
			}
		driver.get(baseURL);

	}
	@AfterClass
	public void teardown() {
		driver.quit();
	
	}
	public static void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	}

