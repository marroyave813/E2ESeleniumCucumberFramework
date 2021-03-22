package baseObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	// Declaration of the webdriver
	public static WebDriver driver;
	// Declaration of the properties object
	public static Properties prop;

	public void InitializeDriver() throws IOException {
		// Instantiate the properties object
		prop = new Properties();
		// Declaration of a file input stream element that will read the configuration
		// file
		FileInputStream fis = new FileInputStream("src/main/java/Configuration/config.properties");
		// Load the properties from the file input stream
		prop.load(fis);
		// declare a browser object
		Browsers browser;
		// Verify if the browser name comes from jenkins
		if (System.getProperty("browser") == null) {
			// if not, then we assign the one on the properties file
			browser = Browsers.valueOf(prop.getProperty("browser"));
		} else {
			// if it comes from jenkins, we get that value
			browser = Browsers.valueOf(System.getProperty("browser"));
		}

		// Select the correct driver depending on the browser on the properties file
		switch (browser) {
		case chrome:
			System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case firefox:
			System.setProperty("webdriver.gecko.driver", "Resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case edge:
			System.setProperty("webdriver.edge.driver", "Resources/msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		case chromeHeadless:
			System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
			break;

		default:
			System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		// Maximize the window of the browser
		driver.manage().window().maximize();
		// Navigate to the URL stored in the properties file
		driver.get(prop.getProperty("url"));
	}

	// Contains the browser drivers in the resources file
	public enum Browsers {
		chrome, firefox, edge, chromeHeadless
	}

	// Method to close and stop the driver process
	public void TearDown() {
		driver.close();
		driver.quit();
		driver = null;
	}

	// Method to get a screenshot
	public String GetScreenError(String name) throws IOException {
		// Define the time format for the filename
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		// Get the actual date
		LocalDateTime now = LocalDateTime.now();
		// Split the current date value
		String[] splitDate = dtf.format(now).toString().split(" ");
		// Split the actual time value
		String[] splitTime = splitDate[1].split(":");
		// Define the filename based on the date and time
		String fileName = name + "-" + splitDate[0] + "-" + splitTime[0] + splitTime[1] + splitTime[2];
		// Define the path to store the screenshots
		String destination = "Screenshots/" + fileName + " - screen.png";
		// Get the screenshot
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Copy the screenshot to the specific path
		FileUtils.copyFile(src, new File(destination));
		return destination;
	}

}
