package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButton(By by) {
        driver.findElement(by).click();
    }

    public void sendKeysToWebElement(By by, String keys) {
        driver.findElement(by).sendKeys(keys);
    }

    public void waitForElement(By by, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void hoverOverPopUpMenu(WebElement webElement) {
        Actions action=new Actions(driver);
        action.moveToElement(webElement).perform();
    }

    public WebElement getWebElement(By by) {
        WebElement webElement = driver.findElement(by);
        return webElement;
    }
}
