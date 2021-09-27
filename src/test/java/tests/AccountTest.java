package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AccountPage;

import java.util.concurrent.TimeUnit;

public class AccountTest {

    //TODO BaseTest
    //BeforeMethod
    //AfterMethod
    @Test
    public void createAccount() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("dmitryrak11-sraq@force.com");
        driver.findElement(By.id("password")).sendKeys("password01");
        driver.findElement(By.id("Login")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title=Home]")));
        driver.get("https://tms5.lightning.force.com/lightning/o/Account/list?filterName=Recent");

        driver.findElement(By.cssSelector("[title=New]")).click();

        new AccountPage(driver).createAccount("Dmitry Rak", "+375213123");

        driver.findElement(By.xpath("//span[contains(text(), 'Save')]")).click();
        driver.quit();
        //КЛИК NEW
        //ЗАПОЛИНТЬ ACCOUNT NAME

        //username
        //password
        //Login
    }
}
