import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver drv;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sk\\IdeaProjects\\exitget\\drivers\\geckodriver.exe");
        drv = new FirefoxDriver();
        drv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        drv.manage().window().maximize();
        drv.get("https://exitget.com");

        MainPage mainPage = new MainPage(drv);
        drv.findElement(By.xpath("//a[@id='learnMoreIconLink']")).click();
        drv.findElement(By.xpath("//div[@id='templateThemes']/div[2]/img")).click();


    }
}
