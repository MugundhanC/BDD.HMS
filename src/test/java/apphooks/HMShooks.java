package apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.factory.Driverfactory;
import com.utility.Configreader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HMShooks {
	
	private Configreader configread;
	Properties prop;
	private WebDriver driver;
	private Driverfactory drivefact;
	
	
	@Before(order=0)
	public void getproperty()
	{
		configread=new Configreader();
		prop=configread.init_prop();
	}
	
	@Before(order=1)
	public void Launchbrowser()
	{
		String browserName=prop.getProperty("browser");
		drivefact=new Driverfactory();
		driver=drivefact.init_driver(browserName);
	}
	
	@After(order=0)
	public void closebrowser()
	{
		driver.close();
	}
	
	@After(order=1)
	public void teardown(io.cucumber.java.Scenario sec)
	{
		if(sec.isFailed())
		{
			String screenshotname=sec.getName().replaceAll(" ", "_");
			byte[]sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sec.attach(sourcepath, "image/png", screenshotname);
		}
	}

}
