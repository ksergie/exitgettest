import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriver drv;
    private WebDriverWait wait;

    public DashboardPage(WebDriver drv) {
        this.drv = drv;
    }

    private By titlePage = By.xpath("//div[@id='stats_highlight']//div[contains(@value, 'by unique users')]");
    private By accountButton = By.xpath("//button[@id='accountButton']");
    private By passwordField = By.xpath("//input[@id='accountpass2']");
    private By resetAccountButton = By.xpath("//button[text()='RESET ACCOUNT']");
    private By closeButton = By.xpath("//button[text()='CLOSE']");
    private By testResult = By.xpath("//div[text()='VISITORS']/following-sibling::div");
    private By quickStartLink = By.xpath("//a[text()='QuickStart Guide']");
    private By installUrlField = By.xpath("//input[@id='installUrl']");
    private By urlNextButton = By.xpath("//div[@id='inputUrl']/div[2]//input[@value='Next']");
    private By switchDevMode = By.xpath("//div[@class='switch-button-background']");
    private By devModeNextButton = By.xpath(".//*[@id='debugMode']/div[2]/div/button");
    private By filter = By.xpath("//option[@value='button']");
    private By filterEmail = By.xpath("//option[@text()='Email only']");
    private By blackFridayTemplate = By.xpath("//img[@src='//exitget.com/static/images/templates/PurpleBlackFriday3for1Button.png']");
    private By personalDesignNextButton = By.xpath(".//*[@id='customizeDesign']//button[1]");
    private By redirectionUrlField = By.xpath("//input[@id='redirectionUrl']");
    private By redirectUrlNextButton = By.xpath("//div[@id='inputRedirectionUrl']//input[@value='Next']");
    private By selectIntentNextButton = By.xpath(".//*[@id='triggerType']//button");
    private By confirmOpenButton = By.xpath("//button[text()='Open']");
    private By confirmConfirmButton = By.xpath("//button[text()='Confirm']");


    public String getTitle() {
       return wait.until(ExpectedConditions.presenceOfElementLocated(titlePage)).getText();
    }

    public String getTestResult() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(testResult)).getText();
    }

    // Click the "Account" button and reset the account data
    public DashboardPage clearData() {
        wait = new WebDriverWait(drv, 10);
        // click the Account button
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountButton)).click();
        // fill the password field
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys("20exitget17");
        // click the Reset button
        drv.findElement(resetAccountButton).click();
        // Close the Alert window
        drv.switchTo().alert().accept();
        // click the Close button
        drv.findElement(closeButton).click();
        return new DashboardPage(drv);
    }

    public DashboardPage quickStart() {
        wait = new WebDriverWait(drv, 10);
        // click the "QuickStart Guide" link
        wait.until(ExpectedConditions.visibilityOfElementLocated(quickStartLink)).click();
        // input the installation URL
        wait.until(ExpectedConditions.visibilityOfElementLocated(installUrlField)).sendKeys("exitgetester.tumblr.com");
        // and click the "Next" button
        wait.until(ExpectedConditions.visibilityOfElementLocated(urlNextButton)).click();
        // Set up developer mode and click the Next button
        wait.until(ExpectedConditions.visibilityOfElementLocated(switchDevMode)).click();
        drv.findElement(devModeNextButton).click();
        // Redirect Only
        drv.findElement(filter);
        wait.until(ExpectedConditions.visibilityOfElementLocated(filter)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(filterEmail));
        // Click the Purple BlackFriday template
        drv.findElement(blackFridayTemplate).click();
        // Skip Personal design
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalDesignNextButton)).click();
        // Input Redirection URL and click the "Next" button
        wait.until(ExpectedConditions.visibilityOfElementLocated(redirectionUrlField)).sendKeys("https://exitget.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(redirectUrlNextButton)).click();
        // Set Time delay and click the Next button
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectIntentNextButton)).click();
        // Confirm Installation
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOpenButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmConfirmButton)).click();

        return new DashboardPage(drv);
    }

}
