package org.basemethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;

public class BaseMethods implements Browser, Element {

	public static RemoteWebDriver driver;
	public static WebDriverWait wait;
	public static Logger log = LogManager.getLogger(BaseMethods.class);

	public void click(WebElement ele) {
		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
		} catch (StaleElementReferenceException e) {
			log.info("The Element " + ele + " could not be clicked");
			throw new RuntimeException();
		} finally {
			takeSnap();

		}

	}

	public void clear(WebElement ele) {
		try {
			ele.clear();
			log.info("The field is cleared Successfully");
		} catch (ElementNotInteractableException e) {
			log.info("The field is not Interactable");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}

	}

	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			log.info("The Data :" + data + " entered Successfully");

		} catch (ElementNotInteractableException e) {
			log.info("The field is not Interactable");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}

	}

	public String getElementText(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	public String getBackgroundColor(WebElement ele) {
		String color = ele.getCssValue("color");
		return color;
	}

	public String getTypedText(WebElement ele) {
		String attributeValue = ele.getAttribute("value");
		return attributeValue;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		new Select(ele).selectByVisibleText(value);

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub

	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub

	}

	public boolean verifyExactText(WebElement ele, String expectedText) {
		try {
			if (ele.getText().equals(expectedText)) {
				System.out.println("The expected text contains the actual " + expectedText);
				return true;
			} else {
				System.out.println("The expected text doesn't contain the actual " + expectedText);
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Text");
		}

		return false;
	}

	public boolean verifyPartialText(WebElement ele, String expectedText) {
		try {
			if (ele.getText().contains(expectedText)) {
				System.out.println("The expected text contains the actual " + expectedText);
				return true;
			} else {
				System.out.println("The expected text doesn't contain the actual " + expectedText);
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Text");
		}

		return false;
	}

	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public boolean verifyDisplayed(WebElement ele) {
		try {
			if (ele.isDisplayed()) {
				System.out.println("The element " + ele + " is visible");
				return true;
			} else {
				System.out.println("The element " + ele + " is not visible");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
		return false;
	}

	public boolean verifyDisappeared(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyEnabled(WebElement ele) {
		try {
			if (ele.isEnabled()) {
				System.out.println("The element " + ele + " is visible");
				return true;
			} else {
				System.out.println("The element " + ele + " is not visible");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
		return false;
	}

	public boolean verifySelected(WebElement ele) {
		try {
			if (ele.isSelected()) {
				System.out.println("The element " + ele + " is selected");
				return true;
			} else {
				System.out.println("The element " + ele + " is not selected");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
		return false;
	}

	public void startApp(String url) {

	}

	public void startApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.silentOutput", "true");
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.navigate().to(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.err.println("The Browser Could not be Launched. Hence Failed");
			throw new RuntimeException();
		} finally {
			takeSnap();

		}

	}

	public WebElement locateElement(String locatorType, String value) {
		try {
			switch (locatorType.toLowerCase()) {
			case "id":
				return driver.findElementById(value);
			case "name":
				return driver.findElementByName(value);
			case "class":
				return driver.findElementByClassName(value);
			case "link":
				return driver.findElementByLinkText(value);
			case "xpath":
				return driver.findElementByXPath(value);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The Element with locator:" + locatorType + " Not Found with value: " + value);
			throw new RuntimeException();
		}
		return null;
	}

	public WebElement locateElement(String value) {
		return driver.findElementById(value);
	}

	public List<WebElement> locateElements(String type, String value) {
		try {
			switch (type.toLowerCase()) {
			case "id":
				return driver.findElementsById(value);
			case "name":
				return driver.findElementsByName(value);
			case "class":
				return driver.findElementsByClassName(value);
			case "link":
				return driver.findElementsByLinkText(value);
			case "xpath":
				return driver.findElementsByXPath(value);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The Element with locator:" + type + " Not Found with value: " + value);
			throw new RuntimeException();
		}
		return null;
	}

	public void switchToAlert() {
		Alert alert = driver.switchTo().alert();

	}

	public void acceptAlert() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			System.out.println("The alert " + text + " is accepted.");
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}

	}

	public void dismissAlert() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			System.out.println("The alert " + text + " is accepted.");
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}

	}

	public String getAlertText() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
		return text;
	}

	public void typeAlert(String data) {
		driver.switchTo().alert().sendKeys(data);

	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			List<String> allhandles = new ArrayList<>(allWindows);
			String exWindow = allhandles.get(index);
			driver.switchTo().window(exWindow);
			System.out.println("The Window With index: " + index + " switched successfully");
		} catch (NoSuchWindowException e) {
			System.err.println("The Window With index: " + index + " not found");
		}

	}

	public void switchToWindow(String title) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			for (String eachWindow : allWindows) {
				driver.switchTo().window(eachWindow);
				if (driver.getTitle().equals(title)) {
					break;
				}
			}
			System.out.println("The Window With Title: " + title + "is switched ");
		} catch (NoSuchWindowException e) {
			System.err.println("The Window With Title: " + title + " not found");
		} finally {
			takeSnap();
		}
	}

	public void switchToFrame(int index) {
		driver.switchTo().frame(index);

	}

	public void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);

	}

	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);

	}

	public void defaultContent() {
		driver.switchTo().defaultContent();

	}

	public boolean verifyUrl(String url) {
		if (driver.getCurrentUrl().equals(url)) {
			System.out.println("The url: " + url + " matched successfully");
			return true;
		} else {
			System.out.println("The url: " + url + " not matched");
		}
		return false;
	}

	public boolean verifyTitle(String title) {
		if (driver.getTitle().equals(title)) {
			System.out.println("Page title: " + title + " matched successfully");
			return true;
		} else {
			System.out.println("Page url: " + title + " not matched");
		}
		return false;
	}

	public void takeSnap() {
		try {
			File src = driver.getScreenshotAs(OutputType.FILE);
			File des = new File("./snaps/snap" + System.currentTimeMillis() + ".png");
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			System.err.println("The SnapShot could not be taken");
		}

	}

	public void close() {
		driver.close();

	}

	public void quit() {
		driver.quit();

	}

	public static String capture() {
		
		try {
			File Dest = new File("./target/screenshots/" + System.currentTimeMillis() + ".png");
			String filepath = Dest.getAbsolutePath();
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), Dest);
			return filepath;
		} catch (WebDriverException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static MediaEntityModelProvider attachScreenshot() throws IOException {

		return MediaEntityBuilder.createScreenCaptureFromPath(capture()).build();

	}
}
