import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver drv;

    public MainPage(WebDriver drv) {
        this.drv = drv;
    }

    private By logInButton = By.xpath("//button[@id='headerLogin']");
    private By getBigButton = By.xpath(".//*[@id='topImageRegister']");
    private By getSmallButton = By.xpath("//button[@id='headerRegister']");
    private By startMarketingButton = By.xpath("//button[@id='generateLeadsButton']");
    private By getBlogLink = By.xpath("//div[@id='footerLinks2']/a[text()='Blog']");
    private By titlePage = By.xpath("//div[@id='topImageBox']/h1");
    private By getAboutUsLink = By.xpath("//div[@id='footerLinks2']/a[text()='About Us']");
    private By triggersButton = By.xpath("//div[@id='screenshotListOptions']/a[text()='Triggers']");
    private By scrnshotTriggers = By.xpath("//div[@id='screenshotDisplayArea']/img[contains(@src, 'trigger-settings')]");
    private By exitIntentButton = By.xpath("//div[@id='screenshotListOptions']/a[text()='Exit Intent']");
    private By scrnshotExitIntent = By.xpath("//div[@id='screenshotDisplayArea']/img[contains(@src, 'exit-intent')]");
    private By displayButton = By.xpath("//div[@id='screenshotListOptions']/a[text()='Display']");
    private By scrnshotDisplay = By.xpath("//div[@id='screenshotDisplayArea']/img[contains(@src, 'display-settings')]");
    private By positionButton = By.xpath("//div[@id='screenshotListOptions']/a[text()='Positioning']");
    private By scrnshotPosition = By.xpath("//div[@id='screenshotDisplayArea']/img[contains(@src, 'animation-position')]");
    private By validationButton = By.xpath("//div[@id='screenshotListOptions']/a[text()='Validation']");
    private By scrnshotValidation = By.xpath("//div[@id='screenshotDisplayArea']/img[contains(@src, 'settings-validation')]");
    private By techNewsPopup = By.xpath("//img[contains(@src, 'emailtechpop2')]");
    private By windowNewsPopup = By.xpath("//button[@id='exitget_input_3']");

    //Clict the TechNewsPopup
    public MainPage clickTechNewsPopup(){
        drv.findElement(techNewsPopup).click();
        return this;
    }
    public boolean popupTechNews() {
        return drv.findElement(windowNewsPopup).isDisplayed();
    }

    // Click the Triggers button and check image
    public MainPage clickTriggersButton(){
        drv.findElement(triggersButton).click();
        return this;
    }
    public boolean imgTriggers(){
        return drv.findElement(scrnshotTriggers).isDisplayed();
    }
    // Click the ExitIntent button and check image
    public MainPage clickExitIntentButton(){
        drv.findElement(exitIntentButton).click();
        return this;
    }
    public boolean imgExitIntent(){
        return drv.findElement(scrnshotExitIntent).isDisplayed();
    }
    // Click the Display button and check image
    public MainPage clicktDisplay(){
        drv.findElement(displayButton).click();
        return this;
    }
    public boolean imgDisplay(){
        return drv.findElement(scrnshotDisplay).isDisplayed();
    }
    // Click the Positioning button and check image
    public MainPage clickPosition(){
        drv.findElement(positionButton).click();
        return this;
    }
    public boolean imgPosition(){
        return drv.findElement(scrnshotPosition).isDisplayed();
    }
    // Click the Validation button and check image
    public MainPage clickValidation(){
        drv.findElement(validationButton).click();
        return this;
    }
    public boolean imgValidation(){
        return drv.findElement(scrnshotValidation).isDisplayed();
    }



    // Get page title
    public String getTitle() {
        return drv.findElement(titlePage).getText();
    }

    // Click the AboutUs link
    public AboutUsPage clickAboutUsLink(){
        drv.findElement(getAboutUsLink).click();
        return new AboutUsPage(drv);
    }

    // Click the Blog link
    public BlogPage clickBlogLink() {
        drv.findElement(getBlogLink).click();
        return new BlogPage(drv);
    }

    // Click the LogIn button
    public LogInPage clickLogIn() {
        drv.findElement(logInButton).click();
        return new LogInPage(drv);
    }

    // Click the GetStarted button
    public RegistrationPage clickBigButton() {
        drv.findElement(getBigButton).click();
        return new RegistrationPage(drv);
    }

    // Click the GetStarted! button
    public RegistrationPage clickSmallButton() {
        drv.findElement(getSmallButton).click();
        return  new RegistrationPage(drv);
    }

    // Click the Start Marketing strategy button
    public RegistrationPage clickStartMarketing() {
        drv.findElement(startMarketingButton).click();
        return new RegistrationPage(drv);
    }
}
