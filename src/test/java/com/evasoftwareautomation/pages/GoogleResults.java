package com.evasoftwareautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.evasoftwareautomation.framework.BasePage;

public class GoogleResults extends BasePage {
	
	public GoogleResults(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TOLERANCE), this);
	}
	
	@FindBy(css = "div h3.LC20lb")
	private WebElement firstLink;
	
	@FindBy(tagName = "body")
	private WebElement pageText;
	
	@FindBy(css = "a[href*='tbm=isch']")
	private WebElement imageSearch;
	
	public boolean firstLinkContainsReferenceTo(String phrase) {
		firstLink.click();
		return pageText.getText().contains(phrase);
	}
	
	public void clickImagesSearch() {
		imageSearch.click();
	}
	
	@Override
	public boolean pageTitleContains(String phrase) {
		return super.pageTitleContains(phrase);
	}
}
