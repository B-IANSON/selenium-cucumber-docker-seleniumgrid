package com.evasoftwareautomation.framework;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class BasePage {
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TOLERANCE), this);
	}
	
    protected WebDriver driver;
    protected final static int WAIT_TOLERANCE = 5;
	
	@FindBy(tagName = "a")
	private List<WebElement> links;
     
    protected WebDriver getDriver() {
        return driver;
    }
    
    protected boolean pageTitleContains(String phrase) {
    	WebDriverWait wait = new WebDriverWait(driver, WAIT_TOLERANCE);
    	return wait.until(ExpectedConditions.titleContains(phrase));
	}
    
    protected ArrayList<String> listOfBrokenLinks() {
		ArrayList<String> listOfBrokenLinks = new ArrayList<>();
		int responseCode;
		for (WebElement link : links) {
			String linkValue = link.getAttribute("href");
			try {
				URL url = new URL(linkValue);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("HEAD");
				responseCode = connection.getResponseCode();
			} catch (IOException e) {
				listOfBrokenLinks.add(linkValue);
				continue;
			}
			if (responseCode != 200) {
				listOfBrokenLinks.add(linkValue);
			}
		}
		return listOfBrokenLinks;
	}
    
	protected boolean isImageActive(WebElement image) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(image.getAttribute("src"));
			HttpResponse response = client.execute(request);
			return response.getStatusLine().getStatusCode() == 200;
		} catch (IOException e) {
			return false;
		}
	}
}
