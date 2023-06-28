package com.demoFramework_v1.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.demoFramework_v1.utilities.readConfig;


public class baseClass {
	
	readConfig readconfig = new readConfig();
	
	public String baseURL =    readconfig.getAppURL();
	public String username =   readconfig.getuser();
	public String password =   readconfig.getpass();
	public String chromePath = readconfig.getChromeDriver();
	public String edgePath =   readconfig.getMicrosoftDriver();
	WebDriver driver;
	
	static Logger logger;
	
	
	@BeforeTest
	@Parameters("browser")
	public void SetUp(String browser) {
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		if(browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
			
		}
		else if(browser.equals("edge")){
			
			System.setProperty("webdriver.edge.driver", edgePath);
			driver = new EdgeDriver();
		}
		
		logger = LogManager.getLogger(baseClass.class);
		logger.info("browser selected is " + browser);
		
	}
	
	@AfterTest
	public void TearDown() {
		logger.info("browser has been closed");
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String sname) throws IOException{
	TakesScreenshot ts =  (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + sname + ".png");
	FileUtils.copyFile(source, target);
	
	}
	

}
