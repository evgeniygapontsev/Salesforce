package tests;

import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;
import utils.AllureUtils;

import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest {

    @Test(description = "Test to create a new account")
    public void createNewAccount() {
        boolean isOpened = loginPage
                .open()
                .login("gapontsev91-y4c8@force.com", "password9")
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