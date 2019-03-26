package com.evasoftwareautomation.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.evasoftwareautomation.pages.WikipediaHome;
import com.evasoftwareautomation.utils.Translator;
import com.evasoftwareautomation.world.World;
import com.evasoftwareautomation.domain.User;
import com.evasoftwareautomation.domain.Users;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WikipediaLanguageSteps {
	
    private WebDriver driver;
    private World world;
    private WikipediaHome wikipediaHome;

    public WikipediaLanguageSteps(World world) {
    	this.world = world;
    }
	
	@Before(order = 1)
    public void defineWebDriver() throws Throwable {
        driver = world.getWebDriver();
    }
	
    @Before(order = 2)
    public void initPages() throws Throwable {
    	wikipediaHome = new WikipediaHome(driver);
    }
    
    @Given("^a web browser is on the Wikipedia home page$")
    public void navigateToHomePage() throws Throwable {
    	wikipediaHome.navigateToHomePage();
    }
    
    @Given("^a web browser is on the Wikipedia home page in the required language for \"([^\"]*)\"$")
    public void navigateToHomePage(String user) throws Throwable {
    	wikipediaHome.navigateToHomePage();
    	wikipediaHome.selectLanguage(Users.valueOf(user).getLanguage());
    	world.user = new User(user);
    }
    
    @When("^the \"([^\"]*)\" option is selected$")
    public void selectLanguage(String language) throws Throwable {
    	wikipediaHome.selectLanguage(language);
    }
    
    @Then("^the site is translated to \"([^\"]*)\"$")
    public void languageOfTheSiteIs(String language) throws Throwable {
    	String expectedTranslation = Translator.PAGE_TITLE.getTranslation(language);
    	String actualTranslation = driver.getTitle();
    	assertThat(actualTranslation).isEqualTo(expectedTranslation);
    }
}
