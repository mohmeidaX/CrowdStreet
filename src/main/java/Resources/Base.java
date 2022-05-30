package Resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public Properties prop;
    public WebDriver InitializeBrowser() {

        prop = new Properties();
        FileInputStream fis;

        try {
            fis = new FileInputStream("C:\\Users\\USER\\IdeaProjects\\CrowdStreet\\src\\main\\java\\Resources\\data.properties");
            prop.load(fis);
            String browserName = prop.getProperty("browser");
            String url = prop.getProperty("url");

            if (browserName.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }

            else if (browserName.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(3 , TimeUnit.SECONDS);
        return driver;
    }

}

