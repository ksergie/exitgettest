import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    private WebDriver drv;

    public LogInPage(WebDriver drv) {
        this.drv = drv;
    }

    private By emailField = By.xpath("//input[@id='login_email']");
    private By passwordField = By.xpath("//input[@id='login_password']");
    private By loginButton = By.xpath("//input[@id='login_password']/following-sibling::button[@type='submit']");
    private By fogotPasswordLink = By.xpath("//div[@id='login_frame']//a[text()='Forgot password?']");
    private By closeIcon = By.xpath("//div[@id='login_frame']//img");
    private By titlePage = By.xpath("//div[@id='login_frame']/div/div[1]");

    // Get page title
    public String getTitle() {
        return drv.findElement(titlePage).getText();
    }

    // Input Email
    public LogInPage typeEmail(String email) {
        drv.findElement(emailField).sendKeys(email);
        return this;
    }

    // Input password
    public LogInPage typePassword(String passwd) {
        drv.findElement(passwordField).sendKeys(passwd);
        return this;
    }

    // Click the "Login" button
    public DashboardPage logInExitget(String email, String passwd) {
        this.typeEmail(email);
        this.typePassword(passwd);
        drv.findElement(loginButton).click();
        return new DashboardPage(drv);
    }

    // Click the "Fogot password" link
    public ResetPage resetPasswd(){
        drv.findElement(fogotPasswordLink).click();
        return new ResetPage(drv);
    }

    // Click the "Close" icon
    public MainPage closeWindow() {
        drv.findElement(closeIcon).click();
        return new MainPage(drv);
    }
}
