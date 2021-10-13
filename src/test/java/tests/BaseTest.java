package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import pages.AccountPage;
import pages.LoginPage;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    AccountPage accountPage;

    @BeforeMethod
    public void setUp(@Optional ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        context.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

        System.getenv().getOrDefault("SALESFORCE_URL", PropertyReader.getProperty("salesforce.url"));
        System.getenv().getOrDefault("SALESFORCE_USER", PropertyReader.getProperty("salesforce.user"));
        System.getenv().getOrDefault("SALESFORCE_PASS", PropertyReader.getProperty("salesforce.pass"));
    }

//    @AfterMethod(alwaysRun = true)
//    public void close() {
//        driver.quit();
//    }
}