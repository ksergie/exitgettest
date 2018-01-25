import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver drv;

    public MainPage(WebDriver drv) {
        this.drv = drv;
    }

    private By logInButton = By.xpath("//button[@id='headerLogin']");
    private By getBigButton = By.xpath(".//*[@id='topImageRegister']");
    private By getSmallButton = By.xpath("//button[@id='headerRegister']");
    private By startMarketingButton = By.xpath("//button[@id='generateLeadsButton']");
    private By getBlogLink = By.xpath("//div[@id='footerLinks2']/a[text()='Blog']");
    private By titlePage = By.xpath("//div[@id='topImageBox']/h1");

    // Get page title
    public String getTitle() {
        return drv.findElement(titlePage).getText();
    }
    // Click the Blog link
    public BlogPage clickBlogLink() {
        drv.findElement(getBlogLink).click();
        return new BlogPage(drv);
    }

    // Click the LogIn button
    public LogInPage clickLogIn() {
        drv.findElement(logInButton).click();
        return new LogInPage(drv);
    }

    // Click the GetStarted button
    public RegistrationPage clickBigButton() {
        drv.findElement(getBigButton).click();
        return new RegistrationPage(drv);
    }

    // Click the GetStarted! button
    public RegistrationPage clickSmallButton() {
        drv.findElement(getSmallButton).click();
        return  new RegistrationPage(drv);
    }

    // Click the Start Marketing strategy button
    public RegistrationPage clickStartMarketing() {
        drv.findElement(startMarketingButton).click();
        return new RegistrationPage(drv);
    }
}
