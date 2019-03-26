package com.evasoftwareautomation.framework;

import static java.lang.System.getProperty;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	private String desiredDriver;

	public DriverFactory() {
		desiredDriver = getProperty("browser").toLowerCase();
		if (desiredDriver == null) {
			desiredDriver = "empty";
		}
	}

	public WebDriver getLocalWebDriver() {

		switch (desiredDriver) {

		case "chrome":
			return new ChromeDriver();

		case "headless-chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setHeadless(true);
			return new ChromeDriver(chromeOptions);

		case "firefox":
			return new FirefoxDriver();

		case "headless-firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setHeadless(true);
			return new FirefoxDriver(firefoxOptions);

		default:
			System.err.println("****************************************************************" + "\n"
					+ "You have requested an invalid browser type " + "\n" + "Your request was " + "\"" + desiredDriver
					+ "\"" + "\n" + "Options are chrome, headless-chrome, firefox or headless-firefox" + "\n"
					+ "Build aborted..." + "\n" + "****************************************************************");
			System.exit(1);
			return null;
		}
	}

	public RemoteWebDriver getRemoteWebDriver() {

		URL gridHub = null;
		try {
			gridHub = new URL(Urls.GRID_HOME.getUrl());
		} catch (MalformedURLException e) {
			System.err.println("****************************************************************" + "\n"
					+ "The URL provided for the Selenium Hub is syntactically incorrect " + "\n" + "Your request was "
					+ "\"" + Urls.GRID_HOME.getUrl() + "\"" + "\n" + "Please resubmit with valid URL" + "\n"
					+ "Build aborted..." + "\n" + "****************************************************************");
			System.exit(1);
		}

		switch (desiredDriver) {

		case "chrome":
			return new RemoteWebDriver(gridHub, new ChromeOptions().addArguments("--headless"));

		case "firefox":
			return new RemoteWebDriver(gridHub, new FirefoxOptions().addArguments("--headless"));

		default:
			System.err.println("******************************************" + "\n"
					+ "You have requested an invalid browser type " + "\n" + "Your request was " + "\"" + desiredDriver
					+ "\"" + "\n" + "Options are chrome or firefox" + "\n" + "Build aborted..." + "\n"
					+ "******************************************");
			System.exit(1);
			return null;
		}
	}
}