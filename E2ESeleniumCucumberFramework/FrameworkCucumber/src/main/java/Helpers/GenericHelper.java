package Helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseObjects.BaseClass;

public class GenericHelper extends BaseClass {

	public static void WaitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Method to wait for an element to be present
	public static void WaitForClickability(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(prop.getProperty("implicitWaitTime")));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static WebElement FindElement(By locator)
	{
		WaitForElement(locator);
		return driver.findElement(locator);
	}
	
	public static List<WebElement> FindElements(By locator)
	{
		WaitForElement(locator);
		return driver.findElements(locator);
	}
	
	public static boolean IsElementDisplayed(By locator)
	{
		WaitForElement(locator);
		return FindElement(locator).isDisplayed();
	}
	
	public static String GetText(By locator)
	{
		WaitForElement(locator);
		return FindElement(locator).getText();
	}
	
	public static boolean IsElementEnabled(By locator)
	{
		WaitForElement(locator);
		return FindElement(locator).isEnabled();
	}

}
