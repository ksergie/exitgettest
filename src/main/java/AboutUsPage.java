import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutUsPage {
    private WebDriver drv;

    public AboutUsPage(WebDriver drv) {
        this.drv = drv;
    }

    private By titlePage = By.xpath("//h3[contains(text(), 'a small team of experts')]");

    public String getTitle() {
        return drv.findElement(titlePage).getText();
    }
}
