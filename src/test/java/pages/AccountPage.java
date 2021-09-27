package pages;

import org.openqa.selenium.WebDriver;
import wrappers.Input;

public class AccountPage extends BasePage {

    WebDriver driver;
    //TODO BasePage

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createAccount(String accountName, String phone) {
        new Input(driver, "Account Name").write(accountName);

    }
}
