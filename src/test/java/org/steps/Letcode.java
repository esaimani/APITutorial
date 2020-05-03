package org.steps;

import org.basemethods.BaseMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Letcode extends BaseMethods {

	@Given("Launch the {string} Letcode website")
	public void launchTheLetcodeWebsite(String string) {

		String title = driver.getTitle();

		System.out.println(title);

		Assert.assertEquals(driver.getTitle(), "Welcome to LetCode");

		System.out.println(string + " Launched Successfully");

	}

	@Given("Navigate to workspace")
	public void navigateToWorkspace() {

		WebElement workspace = locateElement("xpath", "//h5[text()='Work Space']");
		workspace.click();

	}

	@Given("Navigate to Input Blog")
	public void navigateToInputBlog() {

		navigateToBlog("input");

	}

	@When("Enter the Firstname {string}")
	public void enterTheFirstname(String string) {

	}

	@When("Append a exisiting text {string}")
	public void appendAExisitingText(String string) {

	}

	@When("Get the textbox value")
	public void getTheTextboxValue() {

	}

	@When("Clear the text")
	public void clearTheText() {

	}

	@When("Verify the Invitable textbox is disabled")
	public void verifyTheInvitableTextboxIsDisabled() {

	}

	@Given("Navigate to Frame Blog")
	public void navigateToFrameBlog() {

		navigateToBlog("frame");
		System.out.println("Frame Title " + driver.getTitle());

	}

}
