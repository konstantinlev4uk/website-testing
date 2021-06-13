import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoadingHomePageTest extends BaseTest {

    @Test
    public void testLoadingHomePage() {
        Assert.assertTrue(homePage.getHomepageLogo().isEnabled(), "The Homepage was not loaded");
    }
}
