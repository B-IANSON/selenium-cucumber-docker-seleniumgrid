package com.evasoftwareautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.evasoftwareautomation.framework.BasePage;

public class WikipediaArticle extends BasePage {
	
	public WikipediaArticle(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TOLERANCE), this);
	}
	
	@FindBy(id = "searchInput")
	private WebElement searchField;
	
	@FindBy(css = "#firstHeading")
	private WebElement articleHeading;
	
	public void searchForPhrase(String phrase) {
		searchField.sendKeys(phrase);
		searchField.submit();
	}
	
	public boolean articleHeaderContains(String interest) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TOLERANCE);
    	wait.until(ExpectedConditions.textToBePresentInElement(articleHeading, interest));
		return articleHeading.getText().contains(interest);
	}
	
	@Override
	public boolean pageTitleContains(String phrase) {
		return super.pageTitleContains(phrase);
	}	
}
