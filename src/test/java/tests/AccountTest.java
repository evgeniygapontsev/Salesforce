package tests;

import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest {

    @Test(description = "Test to create a new account")
    public void createNewAccount() {
        boolean isOpened = loginPage
                .open()
                .login(PropertyReader.getProperty("salesforce.user"), PropertyReader.getProperty("salesforce.pass"))
                .isOpened();
        assertTrue(isOpened, "Home page wasn't opened");

        Account account = AccountFactory.get();
        accountPage
                .open()
                .isPageOpened()
                .clickNew()
                .createAccount(account)
                .clickSave();

    }
}