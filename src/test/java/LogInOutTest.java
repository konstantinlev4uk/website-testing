import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoggedPage;

public class LogInOutTest extends BaseTest {
    LoggedPage loggedPage;

    @Test
    public void testLogin() {
        loggedPage = homePage.logIn(
                properties.getProperty("login"),
                properties.getProperty("password"));
        Assert.assertTrue(loggedPage.getProfileMenuButton().isEnabled(), "Login failed");
    }

    @Test(dependsOnMethods = "testLogin")
    public void testLogOut() {
        HomePage homePage = loggedPage.logOut();
        Assert.assertTrue(homePage.getLogoEntryButton().isEnabled(), "LogOut failed");
    }
}
