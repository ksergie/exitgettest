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
    private By resetOk = By.id("accountResultMessage");


    public String getTitle() {
       return wait.until(ExpectedConditions.presenceOfElementLocated(titlePage)).getText();
    }

    public String getResetDoneMessage() {
        return drv.findElement(resetOk).getText();
    }

    // Click the "Account" button and reset the account data
    public DashboardPage clearData() {
        wait = new WebDriverWait(drv, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys("20exitget17");
        drv.findElement(resetAccountButton).click();
        // Close the Alert window
        drv.switchTo().alert().accept();
        return new DashboardPage(drv);
    }

}
