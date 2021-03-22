package Helpers;

import org.openqa.selenium.By;

public class InputHelper {

	public static void InputText(By locator, String text)
	{
		GenericHelper.FindElement(locator).sendKeys(text);
	}
	
	public static void ClearText(By locator)
	{
		GenericHelper.FindElement(locator).clear();
	}
	
	public static String GetText(By locator)
	{
		return GenericHelper.FindElement(locator).getAttribute("Value");
	}
	
}
