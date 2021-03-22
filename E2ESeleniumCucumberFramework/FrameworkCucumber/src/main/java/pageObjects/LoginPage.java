package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Helpers.ButtonHelper;
import Helpers.GenericHelper;
import Helpers.InputHelper;
import baseObjects.BaseClass;

public class LoginPage extends BaseClass{
	
	WebDriver driver;
	
	By emailInput = By.id("user_email");
	By passwordInput = By.id("user_password");
	By loginButton = By.name("commit");
	
	Logger log = LogManager.getLogger(this.getClass().getName());
	
	public LoginPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void EnterEmail(String email)
	{
		InputHelper.InputText(emailInput, email);
		log.info("The email information has been entered");
	}
	
	public void EnterPassword(String password)
	{
		InputHelper.InputText(passwordInput, password);
		log.info("The password information has been entered");
	}
	
	public void ClickLogIn()
	{
		ButtonHelper.ClickButton(loginButton);
		log.info("Click the login option");
	}

}
