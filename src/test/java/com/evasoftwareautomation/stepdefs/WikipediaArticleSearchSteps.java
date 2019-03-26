package com.evasoftwareautomation.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

import com.evasoftwareautomation.pages.WikipediaArticle;
import com.evasoftwareautomation.world.World;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WikipediaArticleSearchSteps {
	
    private WebDriver driver;
    private World world;
    private WikipediaArticle wikipediaArticle;
    
    public WikipediaArticleSearchSteps(World world) {
    	this.world = world;
    }
	
	@Before(order = 1)
    public void defineWebDriver() throws Throwable {
        driver = world.getWebDriver();
    }
	
    @Before(order = 2)
    public void initPages() throws Throwable {
    	wikipediaArticle = new WikipediaArticle(driver);
    }
    
    
    @When("^the users subject of interest is searched for$")
    public void usersSubjectOfInterestIsSearchedFor() throws Throwable {
    	wikipediaArticle.searchForPhrase(world.user.getUserInterest());
    }
    
    @Then("^the article related to the users interest is displayed")
    public void articleOfUsersInterestDisplayed() throws Throwable {
    	assertThat(wikipediaArticle.articleHeaderContains(world.user.getUserInterest())).isTrue();
    }
}
