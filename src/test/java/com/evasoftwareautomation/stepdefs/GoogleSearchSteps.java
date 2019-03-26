package com.evasoftwareautomation.stepdefs;

import org.openqa.selenium.WebDriver;

import com.evasoftwareautomation.pages.GoogleHome;
import com.evasoftwareautomation.pages.GoogleImages;
import com.evasoftwareautomation.pages.GoogleResults;
import com.evasoftwareautomation.world.World;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSearchSteps {
	
    private WebDriver driver;
    private World world;
    private GoogleHome googleHome;
    private GoogleResults googleResults;
    private GoogleImages googleImages;
    
    public GoogleSearchSteps(World world) {
    	this.world = world;
    }
	
	@Before(order = 1)
    public void defineWebDriver() throws Throwable {
        driver = world.getWebDriver();
    }
    
	@Before(order = 2)
    public void initPages() throws Throwable {
        googleHome = new GoogleHome(driver);
        googleResults = new GoogleResults(driver);
        googleImages = new GoogleImages(driver);
    }
    
    @Given("^a web browser is on the Google home page$")
    public void navigateToHomePage() throws Throwable {
    	googleHome.navigateToHomePage();
    }
    
    @When("^the search text \"([^\"]*)\" is entered$")
    public void theSearchPhraseIsEntered(String phrase) throws Throwable {
        googleHome.searchForPhrase(phrase);
    }
    
    @When("^the phrase \"([^\"]*)\" is keyed into the search box$")
    public void theSearchPhraseIsKeyed(String phrase) throws Throwable {
        googleHome.keyPhrase(phrase);
    }

    @Then("^results for entered text \"([^\"]*)\" are shown$")
    public void resultsForAreShown(String phrase) throws Throwable {
        assertThat(googleResults.pageTitleContains(phrase)).isTrue();
    }
    
    @Then("^the first suggested image for \"([^\"]*)\" is displayed successfully$")
    public void relatedImagesAreShown(String phrase) throws Throwable {
        assertThat(googleImages.imageDisplayedSuccessfullyAndDescriptionContains(phrase)).isTrue();
    }
    
    @Then("^suggestions for \"([^\"]*)\" are displayed$")
    public void ajaxSuggestionsContain(String phrase) throws Throwable {
    	assertThat(googleHome.allSuggestionsContain(phrase)).isTrue();
    }
    
    @And("^the first suggested link contains content related to \"([^\"]*)\"$")
    public void firstSuggestedLinkContains(String phrase) throws Throwable {
        assertThat(googleResults.firstLinkContainsReferenceTo(phrase)).isTrue();
    }
    
    @And("^the Images option from the results page is selected$")
    public void imagesOptionSelected() throws Throwable {
        googleResults.clickImagesSearch();
    }
}
