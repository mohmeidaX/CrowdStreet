package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageObjects {

    public WebDriver driver;
    By createAccount = By.cssSelector("a[href*='create-account']");

    public LandingPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCreateAccountPage() {

        return driver.findElement(createAccount);

    }

}
