package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends PageObject
{
    String current_lang;
    WebDriverWait wait;

    @FindBy(xpath="//a[contains(text(),'Wealth Management')]")
    private WebElement wealthmanagementbar;

    @FindBy(xpath="//a[contains(text(),'Your life goals')]")
    private WebElement yourifegoalsbaroption;

    @FindBy(xpath="//ul[@aria-hidden='false']")
    private WebElement wealthmanagementmenu;

    @FindBy(xpath="//img[@class='logo__img']")
    private WebElement mainpagelogo;

    @FindBy(xpath="//span[contains(text(),'Contact')]")
    private WebElement contactbar;

    @FindBy(xpath="//a[contains(text(),'Contact us')]")
    private WebElement contactusoption;

    @FindBy(xpath="//a[contains(text(),'Locations')]")
    private WebElement locationoption;

    public MainPage(WebDriver driver) //default english
    {
        super(driver);
        current_lang = "EN";
    }


    public WealthManagementPage GotoWealthManagementPage()
    {
        this.wealthmanagementbar.click();
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@aria-hidden='false']")));
        this.yourifegoalsbaroption.isDisplayed();
        this.yourifegoalsbaroption.click();
        return new WealthManagementPage(driver);
    }

    public ContactUsPage GoToContactUs()
    {
        this.contactbar.click();
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Tools & Services']/..//ul[@aria-hidden='false']")));
        this.contactusoption.isDisplayed();
        this.contactusoption.click();
        return new ContactUsPage(driver);
    }

    public Locations GoToLocations()
    {
        //driver.findElement(By.xpath("//span[contains(text(),'Contact')]")).click();
        this.contactbar.click();
        wait = new WebDriverWait(this.driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Tools & Services']/..//ul[@aria-hidden='false']")));
        //driver.findElement(By.xpath("//a[contains(text(),'Locations')]")).click();
        this.locationoption.isDisplayed();
        this.locationoption.click();
        return new Locations(driver);
    }



    public void ChangeLanguage(String lang)
    {
        if(current_lang != lang)
        {
            driver.findElement(By.xpath("//a[@lang="+lang+"]")).click();
        }
    }

    public boolean LogoPresent()
    {
        return this.mainpagelogo.isDisplayed();
    }
}
