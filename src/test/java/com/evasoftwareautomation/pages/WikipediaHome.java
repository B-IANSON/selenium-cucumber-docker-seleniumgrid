package com.evasoftwareautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.evasoftwareautomation.framework.BasePage;
import com.evasoftwareautomation.framework.Urls;

public class WikipediaHome extends BasePage {
	
	public WikipediaHome(WebDriver driver) {
		super(driver);	
	}
	
	public void navigateToHomePage() {
		getDriver().navigate().to(Urls.WIKI_HOME.getUrl());
	}
	
	public void selectLanguage(String language) {
		WebElement requestedLanguage = driver.findElement(By.cssSelector("a[title=\""+ language + "\"]"));
		requestedLanguage.click();
	}
	
	@Override
	public boolean pageTitleContains(String phrase) {
		return super.pageTitleContains(phrase);
	}
}
