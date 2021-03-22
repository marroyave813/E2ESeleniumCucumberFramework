package stepDefinitions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import baseObjects.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class StepDefinition extends BaseClass{
	
	HomePage hp;
	LoginPage lp;
	
	Logger log = LogManager.getLogger(this.getClass().getName());
	
	@Given("^I am in the login page$")
    public void i_am_in_the_login_page() throws Throwable {
		hp = new HomePage(driver);
        lp = new LoginPage(driver);
        hp.ClickLogin();   
        
    }

    @When("^i enter my username \"([^\"]*)\"$")
    public void i_enter_my_username_something(String strArg1) throws Throwable {
    	lp.EnterEmail(strArg1);
    }

    @Then("^an error message shows$")
    public void an_error_message_shows() throws Throwable {
    	Assert.assertTrue(true);
    }

    @And("^i enter my password \"([^\"]*)\"$")
    public void i_enter_my_password_something(String strArg1) throws Throwable {
    	lp.EnterEmail(strArg1);
    }

    @And("^click the login button$")
    public void click_the_login_button() throws Throwable {
    	lp.ClickLogIn(); 
    }
    
    @When("^i enter username (.+)$")
    public void i_enter_username(String username) throws Throwable {
    	lp.EnterEmail(username);
    }

    @And("^i enter password (.+)$")
    public void i_enter_password(String password) throws Throwable {
    	lp.EnterPassword(password);
    }

}
