import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver drv;
    private LogInPage logInPage;
    private MainPage mainPage;

    @Before
    public void setUp() {
        // Check the path to the driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sk\\IdeaProjects\\exitgettest\\drivers\\chromedriver.exe");
        drv = new ChromeDriver();
        drv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        drv.manage().window().maximize();
        logInPage = new LogInPage(drv);
        mainPage = new MainPage(drv);
        drv.get("https://exitget.com");
        mainPage.clickLogIn();
    }

    @Test
    public void LoginWithCorrectData() {
        DashboardPage dashboardPage = logInPage.logInExitget("exitgetest@gmail.com", "20exitget17");
        String title = dashboardPage.getTitle();
        Assert.assertEquals("VISITATIONS", title);
    }
    @After
    public void tearDown() {
        drv.quit();
    }
}
