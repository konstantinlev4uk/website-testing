import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LoggedPage;
import page.UploadingAvatarPage;

import java.io.File;

public class UploadingAvatarTest extends BaseTest {

    final String DEFAULT_AVATAR = "2116014.jpg";

    @Test
    public void testUploadingAvatar() {
        LoggedPage loggedPage = homePage.logIn(
                properties.getProperty("login"),
                properties.getProperty("password"));

        String avatarPath = new File("").getAbsolutePath().replace("\\","/")
                + properties.getProperty("avatar.cat.path");

        UploadingAvatarPage uploadingAvatarPage = loggedPage.goToUploadingAvatarPage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(
                uploadingAvatarPage.getAvatarSource().contains(DEFAULT_AVATAR),
                "Default avatar image is not present before avatar downloading"
        );

        uploadingAvatarPage = uploadingAvatarPage.uploadingAvatarImage(avatarPath);

        softAssert.assertFalse(
                uploadingAvatarPage.getAvatarSource().contains(DEFAULT_AVATAR),
                "Default avatar image is present after users avatar was downloading"
        );
        softAssert.assertAll();
    }
}
