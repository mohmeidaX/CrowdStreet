package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPageObjects {

    public WebDriver driver;
    By firstName = By.id("firstName");
    By secondName = By.id("lastName");
    By email = By.id("email");
    By password = By.id("password");
    By confirmPassword = By.id("confirmPassword");
    By accreditedCheckBox= By.id("accreditedYes");
    By hasAgreedTos = By.id("hasAgreedTos");
    By submitButton = By.xpath("//span[contains(text(),'Create an account')]");

    public RegistrationPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFirstName() {

        return driver.findElement(firstName);
    }

    public WebElement getLastName() {

        return driver.findElement(secondName);
    }

    public WebElement getEmail() {

        return driver.findElement(email);
    }

    public WebElement getPassword() {

        return driver.findElement(password);
    }

    public WebElement getPasswordConfirm() {

        return driver.findElement(confirmPassword);
    }
    public WebElement getAccreditedCheckBox() {

        return driver.findElement(accreditedCheckBox);
    }
    public WebElement getHasAgreedTos() {

        return driver.findElement(hasAgreedTos);
    }
    public WebElement getSubmitButton() {

        return driver.findElement(submitButton);
    }
}
