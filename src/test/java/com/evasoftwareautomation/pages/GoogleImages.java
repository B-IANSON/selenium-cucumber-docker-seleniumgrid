package com.evasoftwareautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.evasoftwareautomation.framework.BasePage;

public class GoogleImages extends BasePage {

	public GoogleImages(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TOLERANCE), this);
	}
	
	@FindBy(css = "#rg img[alt*='Image result for']")
	private WebElement firstImagePreClick;
	
	@FindBy(css = "div img.irc_mi[alt*='Image result for']")
	private WebElement firstImagePostClick;

	public boolean imageDisplayedSuccessfullyAndDescriptionContains(String phrase) {
		firstImagePreClick.click();
		if (firstImagePostClick.getAttribute("alt").contains(phrase) && isImageActive(firstImagePostClick)) {
			return true;
		} else {
			return false;
		}
	}
}
