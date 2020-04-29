package org.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.basemethods.BaseMethods;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateNewRegisterSteps extends BaseMethods {

	static Logger log = LogManager.getLogger(CreateNewRegisterSteps.class);

	@Given("^Irctc URL should be opened$")
	public void irctcURLShouldBeOpened() throws Throwable {

		startApp("chrome", "https://www.irctc.co.in/nget/");

		System.out.println("Inage File path " + capture());

		// Reporter.addStepLog("Irctc URL should be opened");

		// logger.addScreenCaptureFromPath(capture(), "Irctc URL Launched");

	}

	@Given("^Click on Register Link$")
	public void clickOnRegisterLink() throws Throwable {

		log.info("Click on Register Link");
		// logger.pass("Click on Register Link ",attachScreenshot());

	}

	@Given("^Enter the all mandatory Informations$")
	public void enterTheAllMandatoryInformations() throws Throwable {

		log.info("Enter the all mandatory Informations");

	}

	@When("^User clicks on Register Button$")
	public void userClicksOnRegisterButton() throws Throwable {

		log.info("User clicks on Register Button");
	}

	@Then("^User Created Successfully message shoud displayed$")
	public void userCreatedSuccessfullyMessageShoudDisplayed() throws Throwable {

		log.info("User Created Successfully message shoud displayed");
	}

}
