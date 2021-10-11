package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {

    WebDriver driver;
    String label;

    String dropdown = "//span[contains(text(), 'Type')]/ancestor::div[contains(@class, 'uiInputSelect')]//a";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format(dropdown, label))).click();
        driver.findElement(By.xpath(String.format("//a[@title='%s']", option))).click();
    }
}
