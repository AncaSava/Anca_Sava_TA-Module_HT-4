package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page_objects.TopBar;

import static org.example.stepdefinitions.BaseSteps.driver;

public class TopBarSteps {

    TopBar navBar = new TopBar(driver);
    @Given("User  enters  headphones in the searchBar on TopBar")
    public void userEntersHeadphonesInTheSearchBarOnTopBar() {
        navBar.searchMethod("headphones");
    }
}
