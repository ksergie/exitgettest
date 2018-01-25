import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver drv;

    public DashboardPage(WebDriver drv) {
        this.drv = drv;
    }

    private By titlePage = By.xpath("//div[@id='stats_highlight']//div[contains(@value, 'by unique users')]");

    public String getTitle() {
       return drv.findElement(titlePage).getText();
    }
}
