import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxSmokeTest {
    private WebDriver drv;
    private DashboardPage dashboardPage;
    private LogInPage logInPage;
    private MainPage mainPage;

    @Before
    public void setUp() {
        // Check the path to the driver


        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\IdeaProjects\\exitgettest\\drivers\\geckodriver.exe");

        // Select the browser

        drv = new FirefoxDriver();


        drv.manage().window().maximize();
        dashboardPage = new DashboardPage(drv);
        logInPage = new LogInPage(drv);
        mainPage = new MainPage(drv);
        drv.get("https://exitget.com");
        mainPage.clickLogIn();

    }

    @Test
    public void smokeTest() {
        DashboardPage dashboardPage = logInPage.logInExitget("exitgetest@gmail.com", "20exitget17");
        dashboardPage.clearData();
        Assert.assertEquals("FAULT: the account is not cleared", "0", dashboardPage.getTestResult());
        dashboardPage.quickStart();
    }


    @After
    public void tearDown() {
        drv.quit();
    }

}
