package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {
	public WebDriver driver;
	
	//thread local concept
	public static ThreadLocal<WebDriver>tldriver=new ThreadLocal<>();
	
	//initial setup
	public WebDriver init_driver(String browser)
	{
	
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());
		}
		else
		{
			System.out.println("Invalid Browser Name"+browser);
		}
		getdriver().manage().deleteAllCookies();
		getdriver().manage().window().maximize();
		
		
		return getdriver();
		
	}
	//Get driver
	public static synchronized WebDriver getdriver()
	{
		return tldriver.get();
		
	}
	

}
