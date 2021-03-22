package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ButtonHelper {
	
	public static void ClickButton(By locator)
	{
		GenericHelper.FindElement(locator).click();
	}

}
