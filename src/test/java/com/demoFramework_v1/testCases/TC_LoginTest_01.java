package com.demoFramework_v1.testCases;
import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.demoFramework_v1.pageObjects.loginPage;

public class TC_LoginTest_01 extends baseClass{
	
	@Test
	public void LoginTestCase() {
		
		logger.info("Open URL");
		
		driver.get(baseURL);
		
		loginPage lp = new loginPage(driver);
		
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSubmit();
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Title Page present");
					
			
		}else {
			
		    try {
				captureScreen(driver,"LoginTestCase");
			} catch (IOException e) {
					e.printStackTrace();
			}		
			Assert.assertTrue(false);
			logger.error("Title Page not present");	
			
		}		
		
	}
	
}
