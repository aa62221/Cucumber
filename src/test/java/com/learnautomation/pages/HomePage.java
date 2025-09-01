package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.learnautomation.hooks.TestHooks;

public class HomePage extends TestHooks{

	WebDriver driver;
	
	public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }	
	
	@FindBy(xpath="//div[@id='nav-link-accountList']//a[contains(@class,'nav-progressive-attribute')]")
	private WebElement signIn;
	
	@FindBy(xpath="//input[@id='ap_email_login']")
	private WebElement username;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement Continue;
	
	@FindBy(xpath="//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy(id="signInSubmit")
	private WebElement submit;
	
	public void clickOnSignIn() {
		signIn.click();
	}
	
	public void enterUsername(String user) throws InterruptedException {
		username.sendKeys(user);
		Thread.sleep(2000);
	}
	
	public void clickOnContinue() throws InterruptedException {
        Continue.click();
        Thread.sleep(2000);
    }
	
	public void enterPassword(String pass) throws InterruptedException {
		password.sendKeys(pass);
		Thread.sleep(2000);
	}
	
	public void clickOnSubmit() {
		submit.click();
	}
	
	
}
