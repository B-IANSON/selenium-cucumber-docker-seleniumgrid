package com.evasoftwareautomation.world;

import static java.lang.System.getProperty;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.evasoftwareautomation.domain.User;
import com.evasoftwareautomation.framework.DriverFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class World {

	private WebDriver driver;
	private DriverFactory driverFactory;
	public User user;

	@Before(order = 0)
	public void setUp() throws Throwable {
		driverFactory = new DriverFactory();

		if (getProperty("grid") == null) {
			driver = driverFactory.getLocalWebDriver();
		} else {
			driver = driverFactory.getRemoteWebDriver();
		}
	}

	@After
	public void tearDown(Scenario scenario) throws Throwable {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		driver.quit();
	}

	public WebDriver getWebDriver() {
		return driver;
	}
}
