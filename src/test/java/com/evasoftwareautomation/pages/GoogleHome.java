package com.evasoftwareautomation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.evasoftwareautomation.framework.BasePage;
import com.evasoftwareautomation.framework.Urls;

public class GoogleHome extends BasePage {

	public GoogleHome(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TOLERANCE), this);
	}

	@FindBy(name = "q")
	private WebElement searchField;

	@FindBy(css = "#tsf > div:nth-child(2) > div > div.UUbT9 > div.aajZCb > ul > li")
	private List<WebElement> autoSuggestionsList;

	public void navigateToHomePage() {
		getDriver().navigate().to(Urls.GOOGLE_HOME.getUrl());
	}

	public void searchForPhrase(String phrase) {
		searchField.sendKeys(phrase);
		searchField.submit();
	}

	public void keyPhrase(String phrase) {
		searchField.sendKeys(phrase);
	}

	public boolean allSuggestionsContain(String phrase) {
		if (autoSuggestionsList.isEmpty()) {
			return false;
		} else {
			for (WebElement suggestion : autoSuggestionsList) {
				if (!suggestion.getText().contains(phrase)) {
					return false;
				}
			}
			return true;
		}
	}
	
	@Override
	public ArrayList<String> listOfBrokenLinks() {
		return super.listOfBrokenLinks();
	}
}
