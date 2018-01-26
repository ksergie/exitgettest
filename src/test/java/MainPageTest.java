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

    @Test
    public void clickAboutUslink() {
        AboutUsPage aboutUsPage = mainPage.clickAboutUsLink();
        String title = aboutUsPage.getTitle();
        Assert.assertEquals("We're a small team of experts, dedicated to making the process of growing a business a little easier.", title);
    }

    @Test
    public void clickTriggersButton() {
        mainPage.clickTriggersButton();
        Assert.assertTrue("The pressed Triggers button is not matched the image below", mainPage.imgTriggers());
    }
    @Test
    public void clickExitIntentButton() {
        mainPage.clickExitIntentButton();
        Assert.assertTrue("The pressed Exit Intent button is not matched the image below", mainPage.imgExitIntent());
    }
    @Test
    public void clickDisplayButton() {
        mainPage.clicktDisplay();
        Assert.assertTrue("The pressed Display button is not matched the image below", mainPage.imgDisplay());
    }
    @Test
    public void clickPositionButton() {
        mainPage.clickPosition();
        Assert.assertTrue("The pressed Positioning button is not matched the image below", mainPage.imgPosition());
    }
    @Test
    public void clickValidationButton() {
        mainPage.clickValidation();
        Assert.assertTrue("The pressed Validation button is not matched the image below", mainPage.imgValidation());
    }

    @After
    public void tearDown() {
        drv.quit();
    }
}
