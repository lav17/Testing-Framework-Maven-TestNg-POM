package com.demoFramework_v1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver ldriver;
	
	public loginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement btnLogout;
	
	public void setUsername(String uname) {
		txtUserName.sendKeys(uname);
		
	}
	
	public void setPassword(String upass) {
		txtPassword.sendKeys(upass);
		
	}
	
	public void clickSubmit() {
		btnLogin.click();
		
	}
	
	public void clickLogout() {
		btnLogout.click();
		
	}

}
