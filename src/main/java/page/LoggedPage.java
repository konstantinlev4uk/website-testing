package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedPage extends BasePage {

    private By profileMenuButton = By.xpath("//div[contains(@class, 'headblock-menu')]/button[@type='submit']");
    private By buttonOut = By.xpath("//a[@href='/?mod=logout']");
    private By buttonUploadingAvatar = By.xpath("//a[@href='/?mod=avatar']");

    public LoggedPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProfileMenuButton() {
        return getWebElement(profileMenuButton);
    }

    public HomePage logOut() {
        hoverOverPopUpMenu(getWebElement(profileMenuButton));
        clickButton(buttonOut);
        return new HomePage(driver);
    }

    public UploadingAvatarPage goToUploadingAvatarPage() {
        hoverOverPopUpMenu(getWebElement(profileMenuButton));
        clickButton(buttonUploadingAvatar);
        return new UploadingAvatarPage(driver);
    }
}
