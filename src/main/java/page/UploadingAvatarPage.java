package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadingAvatarPage extends LoggedPage {

    public By buttonChooseFile = By.xpath("//input[@type='file']");
    public By buttonUploadAvatar = By.xpath("//form[@method='post']//button[@type ='submit']");
    public By avatarImage = By.xpath("//form[@method='post']//img");

    public UploadingAvatarPage(WebDriver driver) {
        super(driver);
    }

    public UploadingAvatarPage uploadingAvatarImage(String pathToImage) {
        sendKeysToWebElement(buttonChooseFile, pathToImage);
        clickButton(buttonUploadAvatar);
        return new UploadingAvatarPage(driver);
    }

    public WebElement getAvatarImage() {
        WebElement webElement = driver.findElement(avatarImage);
        return webElement;
    }

    public String getAvatarSource() {
        return getAvatarImage().getAttribute("src");
    }
}
