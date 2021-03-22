package pageObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Helpers.ButtonHelper;
import Helpers.GenericHelper;
import baseObjects.BaseClass;

public class HomePage extends BaseClass{
		
	By loginButton = By.xpath("//a/span[text()='Login']");
	By navigationBar = By.cssSelector(".navbar-collapse.collapse");
	
	Logger log = LogManager.getLogger(this.getClass().getName());
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void ClickLogin()
	{
		ButtonHelper.ClickButton(loginButton);
		log.info("Click the login option");
	}
	
	public boolean IsBarPresent()
	{
		GenericHelper.WaitForElement(navigationBar);
		log.info("The menu bar is present");
		return GenericHelper.IsElementDisplayed(navigationBar);
		
	}

}
