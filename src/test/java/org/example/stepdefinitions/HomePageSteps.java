package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import page_objects.HomePage;
import page_objects.SearchResultsPage;
import page_objects.TopBar;

import java.util.List;

import static org.example.stepdefinitions.BaseSteps.driver;

public class HomePageSteps {

    HomePage homePage = new HomePage(driver);

    @Given("Amazon Home Page is opened")
    public void amazonHomePageIsOpened() {
        homePage.openAmazonHomePageAndJustGoToTopBar();
    }

}
