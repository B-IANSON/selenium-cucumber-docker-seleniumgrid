package com.evasoftwareautomation.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.evasoftwareautomation.pages.GoogleHome;
import com.evasoftwareautomation.world.World;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

public class GoogleLinksSteps {
	
    private WebDriver driver;
    private World world;
    private GoogleHome googleHome;
    
    public GoogleLinksSteps(World world) {
    	this.world = world;
    }
	
	@Before(order = 1)
    public void defineWebDriver() throws Throwable {
        driver = world.getWebDriver();
    }
    
	@Before(order = 2)
    public void initPages() throws Throwable {
		googleHome = new GoogleHome(driver);
    }
	
    @Then("^all links are available for selection$")
    public void validateAllLinks() throws Throwable {
    	assertThat(googleHome.listOfBrokenLinks().isEmpty());
    }
}
