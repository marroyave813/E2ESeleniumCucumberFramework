package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
	 features = "src/test/java/appFeatures",
	 glue={"stepDefinitions"}
	 )
public class TestRunner extends AbstractTestNGCucumberTests {
	
	

}
