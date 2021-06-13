package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import page.HomePage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private String homeLink;
    final int WAIT_TIME = 10;
    private WebDriver driver;
    public HomePage homePage;
    public Properties properties;

    @BeforeClass
    public void setUp() throws IOException {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("uri.properties");
        properties = new Properties();
        properties.load(inputStream);
        homeLink = properties.getProperty("base.uri");

        String chromeDriverPath = new File("").getAbsolutePath()
                + properties.getProperty("webdriver.chrome.driver");

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
        homePage = goToHomePage();
    }

    @BeforeMethod
    public HomePage goToHomePage() {
        driver.get(homeLink);
        return new HomePage(driver);
    }

    @AfterClass
    public void closeChromeDriver() {
        driver.quit();
    }
}
