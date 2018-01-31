import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DashboardPageTest {
    private WebDriver drv;
    private DashboardPage dashboardPage;
    private LogInPage logInPage;
    private MainPage mainPage;

    @Before
    public void setUp() {
        // Check the path to the driver

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sk\\IdeaProjects\\exitgettest\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\sk\\IdeaProjects\\exitgettest\\drivers\\MicrosoftWebDriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sk\\IdeaProjects\\exitgettest\\drivers\\geckodriver.exe");

        // Select the browser

//        drv = new ChromeDriver();
//        drv = new EdgeDriver();
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
        // drv.quit();
    }

}
