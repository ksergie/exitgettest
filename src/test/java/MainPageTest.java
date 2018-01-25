import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver drv;
    private MainPage mainPage;

    @Before
    public void setUp() {
        // Check the path to the driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sk\\IdeaProjects\\exitgettest\\drivers\\chromedriver.exe");
        drv = new ChromeDriver();
        drv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        drv.manage().window().maximize();
        drv.get("https://exitget.com");
        mainPage = new MainPage(drv);
    }

    @Test
    public void pushLoginButton() {
        LogInPage loginPage = mainPage.clickLogIn();
        String title = loginPage.getTitle();
        Assert.assertEquals("Login", title);
    }

    @Test
    public void pushBigGetStartedButton() {
        RegistrationPage registrationPage = mainPage.clickBigButton();
        String title = registrationPage.getTitle();
        Assert.assertEquals("Registration", title);
    }

    @Test
    public void pushSmallGetStartButton() {
        RegistrationPage registrationPage = mainPage.clickSmallButton();
        String title = registrationPage.getTitle();
        Assert.assertEquals("Registration", title);
    }

    @Test
    public void pushStartMarketingButton() {
        RegistrationPage registrationPage = mainPage.clickStartMarketing();
        String title = registrationPage.getTitle();
        Assert.assertEquals("Registration", title);
    }

    @Test
    public void clickBloglink() {
        BlogPage blogPage = mainPage.clickBlogLink();
        String title = blogPage.getTitle();
        Assert.assertEquals("Subscribe to us", title);
    }
    @After
    public void tearDown() {
        drv.quit();
    }
}
