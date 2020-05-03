package org.steps;

import org.basemethods.BaseMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseMethods {

	@Before
	public void launchApp() {

		startApp("chrome", "https://letcode.in/");

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
