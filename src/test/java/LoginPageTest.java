import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver drv;
    private LogInPage logInPage;
    private MainPage mainPage;
    private DashboardPage dashboardPage;

    @Before
    public void setUp() {
        // Check the path to the driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sk\\IdeaProjects\\exitgettest\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\sk\\IdeaProjects\\exitgettest\\drivers\\MicrosoftWebDriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sk\\IdeaProjects\\exitgettest\\drivers\\geckodriver.exe");

//        Select the browser

//        drv = new ChromeDriver();
//        drv = new FirefoxDriver();
        drv = new EdgeDriver();

        drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        drv.manage().window().maximize();
        logInPage = new LogInPage(drv);
        mainPage = new MainPage(drv);
        dashboardPage = new DashboardPage(drv);
        drv.get("https://exitget.com");
        mainPage.clickLogIn();
    }

    @Test
    public void withCorrectData() {
        DashboardPage dashboardPage = logInPage.logInExitget("exitgetest@gmail.com", "20exitget17");
        Assert.assertEquals("exitgettest", dashboardPage.getTitle());
    }

    @Test
    public void withoutData() {
        DashboardPage dashboardPage = logInPage.logInExitget("", "");
        Assert.assertEquals("You must provide the email address you registered with.", logInPage.getToolTip());
    }

    @Test
    public void withoutPasswd() {
        DashboardPage dashboardPage = logInPage.logInExitget("exitgetest@gmail.com", "");
        Assert.assertEquals("You must provide a password to login.", logInPage.getToolTip());
    }

    @Test
    public void withIncorrectEmail() {
        DashboardPage dashboardPage = logInPage.logInExitget("123qwer", "");
        Assert.assertEquals("You must provide a valid email address.", logInPage.getToolTip());
    }

    @Test
    public void CorrectEmailIncorrectPasswd() {
        DashboardPage dashboardPage = logInPage.logInExitget("exitgetest@gmail.com", "00000");
        Assert.assertEquals("The login information you provided was not correct.", logInPage.getToolTip());
    }

    @Test
    public void UnregisteredEmail() {
        DashboardPage dashboardPage = logInPage.logInExitget("test_test@gmail.com", "0000");
        Assert.assertEquals("The login information you provided was not correct.", logInPage.getToolTip());
    }

    @Test
    public void clickCloseIcon() {
        MainPage mainPage = logInPage.closeWindow();
        Assert.assertEquals("A Popup Platform for Everyone", mainPage.getTitle());
    }

    @Test
    public void clickForgotlink(){
        ResetPage resetPage = logInPage.resetPasswd();
        Assert.assertEquals("Reset", resetPage.getTitle());
    }

    @After
    public void tearDown() {
        drv.quit();
    }
}
