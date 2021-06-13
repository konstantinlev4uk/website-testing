package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    //название сущность в конце входкнопка
    final int WAIT_TIME = 10;
    private By buttonEntry = By.xpath("//a[@href='/?mod=login']");
    private By buttonEnter = By.xpath("//div[@class='loginbox-login']/button[@type='submit']");
    private By fieldLogin = By.xpath("//div[@class='loginbox-login']/input[@type='text']");
    private By fieldPassword = By.xpath("//div[@class='loginbox-login']/input[@type='password']");
    private By logoHomepage = By.xpath("//a[@class='header_logo special-home']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHomepageLogo() {
        return getWebElement(logoHomepage);
    }

    public WebElement getLogoEntryButton() {
        return getWebElement(buttonEntry);
    }

    public LoggedPage logIn(String login, String password) {
        clickButton(buttonEntry);
        waitForElement(fieldLogin, WAIT_TIME);
        sendKeysToWebElement(fieldLogin, login);
        sendKeysToWebElement(fieldPassword, password);
        clickButton(buttonEnter);
        return new LoggedPage(driver);
    }
}
