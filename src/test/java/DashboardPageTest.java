import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class DashboardPageTest {
    private WebDriver drv;
    private DashboardPage dashboardPage;
    private LogInPage logInPage;
    private MainPage mainPage;

    @Before
    public void setUp() {
        // Check the path to the driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sk\\IdeaProjects\\exitgettest\\drivers\\chromedriver.exe");
        drv = new ChromeDriver();
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
    }


    @After
    public void tearDown() {
        drv.quit();
    }

}
