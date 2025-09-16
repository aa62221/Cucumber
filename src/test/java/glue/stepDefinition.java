package glue;

import org.openqa.selenium.WebDriver;

import com.learnautomation.hooks.TestHooks;
import com.learnautomation.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition {
	
	 WebDriver driver;
	 HomePage home;
	 TestHooks th=new TestHooks();
	@Given("I am on the home page")
	public void i_am_on_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		
		driver=th.getDriver();
	    driver.get("https://www.amazon.in/"); 
	}

	@When("I navigate to the sign in page")
	public void i_navigate_to_the_sign_in_page() {
	   home=new HomePage(driver);
	   home.clickOnSignIn();       
	}
	
	@When("I log in with username {string} and password {string}")
	public void i_log_in_with_username_and_password(String user, String pass) throws InterruptedException {
	    home.enterUsername(user);
	    home.clickOnContinue();
	    home.enterPassword(pass);
	}

	
	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
		home.clickOnSubmit();
	}


	

	
	
	

}
