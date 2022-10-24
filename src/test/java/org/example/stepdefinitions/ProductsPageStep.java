package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page_objects.SearchResultsPage;

import java.util.List;

import static org.example.stepdefinitions.BaseSteps.driver;

public class ProductsPageStep {

    List<WebElement> searchResults;

    @When("user clicks on sonyOption on SearchResultsPage")
    public List<WebElement> userClicksOnSonyOptionOnSearchResultsPage() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        return searchResults = searchResultsPage.clickOnSony().returnSearchResultsForSony();
    }

    @Then("User is provided with a list of results in the SearchResultsPage")
    public void userIsProvidedWithAListOfResultsInTheSearchResultsPage() {
        List<WebElement> verifySearchResults = userClicksOnSonyOptionOnSearchResultsPage();
        verifySearchResults
                .stream()
                .filter(x -> x.getText().toLowerCase().contains("sony") & x.getText().contains("Headphones"))
                .toList();
        Assert.assertEquals(searchResults.size(), verifySearchResults.size());
    }

    @When("user clicks on price range option  on SearchResultsPage")
    public void userClicksOnPriceRangeOptionOnSearchResultsPage() {

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.clickOnPriceRangeOption().clickOnSort().clickOnSortFromLowToHigh();

    }

    List<WebElement> searchResultsAccordingToPrice;

    @When("User clicks only on price range option  on SearchResultsPage")
    public void userClicksOnlyOnPriceRangeOptionOnSearchResultsPage() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsAccordingToPrice = searchResultsPage.clickOnPriceRangeOption().returnSearchResultsForPriceRangeOption();
    }

    @Then("User is provided with a list of results sorted by price in the SearchResultsPage")
    public void userIsProvidedWithAListOfResultsSortedByPriceInTheSearchResultsPage() {
        List<Integer> listWithPricesHigherThan200 = searchResultsAccordingToPrice
                .stream()
                .filter(x -> x.getText() != "")
                .map(x -> Integer.parseInt(x.getText().replace(",", "")))
                .filter(x -> x > 200)
                .toList();
        Assert.assertTrue(listWithPricesHigherThan200.size() >= searchResultsAccordingToPrice.size() / 2);
    }

    @Then("User is provided with a list of  results sorted from low to high in the SearchResultsPage")
    public void userIsProvidedWithAListOfResultsSortedFromLowToHighInTheSearchResultsPage() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        String s = searchResultsPage.getTextOfAssertionElementAfterSorting();
        Assert.assertEquals(s, "Price: Low to High");
    }
}
