import PageObjects.LandingPageObjects;
import PageObjects.RegistrationPageObjects;
import Resources.Base;
import org.bouncycastle.crypto.prng.RandomGenerator;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LandingPage extends Base {

    public WebDriver driver;

    @BeforeTest
    public void Initialize() {
        //Call method to initialize browser
        driver = InitializeBrowser();
    }

    @Test(priority = 1)
    public void NavigateToRegistrationPage(){
        //Navigate to Web Page
        driver.navigate().to(prop.getProperty("url"));
        //Maximize Window
        driver.manage().window().maximize();
        //Find Create an Account Button and click on it
        LandingPageObjects lp = new LandingPageObjects(driver);
        //Click on Create an Account Button
        lp.getCreateAccountPage().click();
    }

    @Test(priority = 3 , dataProvider = "getData")
    public void FillOutRegistrationForm(String firstName, String lastName, String email, String pass) throws InterruptedException {
        //Create instance of Registration Page
        RegistrationPageObjects rp = new RegistrationPageObjects(driver);
        //Send FirstName
        rp.getFirstName().sendKeys(firstName);
        //Send LastName
        rp.getLastName().sendKeys(lastName);
        //Send Email
        rp.getEmail().sendKeys(email);
        // Send Password
        rp.getPassword().sendKeys(pass);
        // Send Password again to Confirm
        rp.getPasswordConfirm().sendKeys(pass);
        // Check Yes for "Are you an accredited investor?"
        rp.getAccreditedCheckBox().click();
        // Check box to agree on terms and conditions
        rp.getHasAgreedTos().click();
        //Wait for 5 seconds so user can manually click on CAPTCHA
        Thread.sleep(5000);
        //Click on Submit button
        rp.getSubmitButton().click();
    }

    @DataProvider
    public Object[][] getData() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);

        Object[][] data = new Object[1][4];
        data[0][0] = "Moe";
        data[0][1] = "hme";
        data[0][2] = "username"+ randomInt +"@gmail.com";
        data[0][3] = "Testing123!";

        return data;
    }

    @AfterTest
    public void Teardown() {
        //Close Driver
        driver.close();
    }

}
