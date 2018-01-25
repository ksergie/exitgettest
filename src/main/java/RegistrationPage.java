import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver drv;

    public RegistrationPage(WebDriver drv) {
        this.drv = drv;
    }

    private By usernameField = By.xpath("//input[@id='registername']");
    private By emailField = By.xpath("//input[@id='registeremail']");
    private By passwordField = By.xpath("//input[@id='registerpass']");
    private By acceptCheckbox = By.xpath("//input[@id='legalCheckbox']");
    private By registerButton = By.xpath("//div[@id='register_frame']//button");
    private By closeIcon = By.xpath("//div[@id='register_frame']//img[@class='close']");
    private By termLink = By.xpath("//input[@id='legalCheckbox']/following-sibling::a[text()='Terms of Service']");
    private By privacyLink = By.xpath("//input[@id='legalCheckbox']/following-sibling::a[text()='Privacy Policy']");
    private By titlePage = By.xpath(".//*[@id='register_frame']/div/div[1]");

    // Get page title
    public String getTitle() {
        return drv.findElement(titlePage).getText();
    }

    // Input username
    public RegistrationPage typeUsername(String username) {
        drv.findElement(usernameField).sendKeys(username);
        return this;
    }

    // Input Email
    public RegistrationPage typeEmail(String email) {
        drv.findElement(emailField).sendKeys(email);
        return this;
    }

    // Input password
    public RegistrationPage typePassword(String password) {
        drv.findElement(passwordField).sendKeys(password);
        return this;
    }

    // Tick the "Accept.." checkbox
    public RegistrationPage tickAccept() {
        if (!drv.findElement(acceptCheckbox).isSelected())
            drv.findElement(acceptCheckbox).click();
        return this;
    }

    // Click the "Register" button
    public DashboardPage registeration(String username, String email, String password) {
        this.typeUsername(username);
        this.typeEmail(email);
        this.typePassword(password);
        this.tickAccept();
        drv.findElement(registerButton).click();
        return new DashboardPage(drv);
    }

    // Click the "Close" icon
    public MainPage closeWindow(){
        drv.findElement(closeIcon).click();
        return new MainPage(drv);
    }

    // Click the "Terms of Service" link
    public TermPage openTermPage() {
        drv.findElement(termLink).click();
        return new TermPage(drv);
    }

    // Click the "Privacy.." link
    public PrivacyPage openPrivacyPage() {
        drv.findElement(privacyLink).click();
        return new PrivacyPage(drv);
    }
}
