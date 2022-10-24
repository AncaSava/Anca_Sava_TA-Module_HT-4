package page_objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openAmazonHomePageAndJustGoToTopBar() {
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        new TopBar(driver);
    }


}