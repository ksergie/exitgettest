import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
    private WebDriver drv;
    private WebDriverWait wait;

    public LogInPage(WebDriver drv) {
        this.drv = drv;
    }

    private By emailField = By.xpath("//input[@id='login_email']");
    private By passwordField = By.xpath("//input[@id='login_password']");
    private By loginButton = By.xpath("//input[@id='login_password']/following-sibling::button[@type='submit']");
    private By fogotPasswordLink = By.xpath("//div[@id='login_frame']//a[text()='Forgot password?']");
    private By closeIcon = By.xpath("//div[@id='login_frame']//img");
    private By titlePage = By.xpath("//div[@id='login_frame']/div/div[1]");
    private By toolTip = By.xpath("//div[@id='login_frame']//div[@class='_logicstatus']");

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
    public LogInPage clickLoginButton(){
        drv.findElement(loginButton).click();
        return this;
    }

    public DashboardPage logInExitget(String email, String passwd) {
        this.typeEmail(email);
        this.typePassword(passwd);
        this.clickLoginButton();
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

    public String getToolTip(){
        wait = new WebDriverWait(drv, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(toolTip)).getText();
    }
}
