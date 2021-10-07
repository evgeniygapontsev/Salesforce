package pages;

import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.DropDown;
import wrappers.Input;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Creating an account with filling in the fields")
    public AccountPage createAccount(Account account) {
        new Input(driver, "Account Name").write(account.getAccountName());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Website").write(account.getWebSite());
        new Input(driver, "Employees").write(account.getEmployees());
        new DropDown(driver, "Type").select(account.getType());
        new DropDown(driver, "Industry").select(account.getIndustry());
        return this;
    }

    @Step("Open account page")
    public AccountPage open() {
        driver.get(baseUrl + "lightning/o/Account/list?filterName=Recent");
        return this;
    }

    @Step("Create new account button")
    public AccountPage clickNew() {
        driver.findElement(By.cssSelector("[title=New]")).click();
        return this;
    }

    @Step("Save new account button")
    public AccountPage clickSave() {
        driver.findElement(By.xpath("(//span[contains(text(), 'Save')])[3]")).click();
        return this;
    }

    public AccountPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title=New]")));
        return this;
    }

}
