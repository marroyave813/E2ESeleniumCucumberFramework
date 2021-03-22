package testResources;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baseObjects.BaseClass;

public class Listeners implements ITestListener{

	//Declaration of the base class element
	BaseClass baseElement = new BaseClass();
	//Declaration of the logger
	Logger log = LogManager.getLogger(this.getClass().getName());
	
	//Method to execute when a test starts
	public void onTestStart(ITestResult result) {
		try {
			//Initialize the driver and the some properties of it
			baseElement.InitializeDriver();
			log.info("The test execution started");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Method to execute when an execution finishes successfully
	public void onTestSuccess(ITestResult result) {
		
		log.info("The test execution finished successfully");
		//The driver is shut down
		baseElement.TearDown();
	}

	//Method to execute when an execution finishes with errors
	public void onTestFailure(ITestResult result) {
		try {
			//Take a screenshot when a test fails
			String destination = baseElement.GetScreenError(result.getName());
			//The driver is shut down
			baseElement.TearDown();
			log.error("The test execution finished with errors");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
