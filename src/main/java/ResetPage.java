import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPage {
    private WebDriver drv;

    public ResetPage(WebDriver drv) {
        this.drv = drv;
    }

    private By titlePage = By.xpath("//div[@id='forgot_frame']/div/div[1]");

    public String getTitle(){
        return drv.findElement(titlePage).getText();
    }
}
