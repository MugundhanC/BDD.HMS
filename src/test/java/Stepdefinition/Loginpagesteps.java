package Stepdefinition;

import org.junit.Assert;

import com.factory.Driverfactory;
import com.pages.Loginpage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginpagesteps {
	private Loginpage objlog=new Loginpage(Driverfactory.getdriver());
	private String title;
	
	@Given("User is on AdminLogin page")
	public void user_is_on_admin_login_page() {
	   Driverfactory.getdriver().get("http://triotend.com/tts/site/login"); 
	}

	@When("User gets the Page Title")
	public void user_gets_the_page_title() {
	   title=objlog.getpagetitle();
	System.out.println(title);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String Expectedtitle) {
	   Assert.assertTrue(title.equals(Expectedtitle)); 
	}

	@Then("Forget password link should be displayed")
	public void forget_password_link_should_be_displayed() {
	   Assert.assertTrue(objlog.isforgetpwdlinkdisplayed());
	}

	@When("User Enters the username {string}")
	public void user_enters_the_username(String username) {
	   objlog.enterusername(username);
	}

	@When("User Enters the password {string}")
	public void user_enters_the_password(String pwd) {
	    objlog.enterpassword(pwd);
	}

	@When("User click on signin button")
	public void user_click_on_signin_button() {
	    objlog.clickonlogin();
	}

	@Then("User get the admin dashboard page title")
	public void user_get_the_admin_dashboard_page_title() {
	    title=objlog.getpagetitle();
	    System.out.println(title);
	}

	@Then("The page title should be {string}")
	public void the_page_title_should_be(String Expectedtitle) {
	   Assert.assertTrue(title.equals(Expectedtitle));
	}

}
