package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
	private WebDriver driver;
	
	//By locators
	private By Username=By.cssSelector("input#email");
	private By Password=By.cssSelector("input#password");
	private By Signin=By.cssSelector("button.btn");
	private By forgetpwdlink=By.cssSelector("a.forgot");
	
	//Constructors
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}

	//Page Actions
	public String getpagetitle()
	{
		return driver.getTitle();
		
	}
	public boolean isforgetpwdlinkdisplayed() 
	{
		return driver.findElement(forgetpwdlink).isDisplayed();
		
	}
	public void enterusername(String uname)
	{
		driver.findElement(Username).sendKeys(uname);
	}
	public void enterpassword(String pwd)
	{
		driver.findElement(Password).sendKeys(pwd);
		
	}
	public void clickonlogin()
	{
		driver.findElement(Signin).click();
	}
	
	
	
	
	
	
}
