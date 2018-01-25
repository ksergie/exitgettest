import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage {
    private WebDriver drv;

    public BlogPage(WebDriver drv) {
        this.drv = drv;
    }

    private By titlePage = By.xpath("//h3[text()='Subscribe to us']");

    public String getTitle() {
        return drv.findElement(titlePage).getText();
    }
}
