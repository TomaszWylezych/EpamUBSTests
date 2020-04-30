package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locations extends PageObject
{
    WebDriverWait wait;

    @FindBy(xpath="//h1[contains(text(),'Locations')]")
    private WebElement headerlocations;

    @FindBy(xpath="//div[@id='loFi-map']")
    private WebElement maplocations;

    @FindBy(xpath="//input[@id='globalSearch']")
    private WebElement searchbox;

    @FindBy(xpath="//input[@id='globalSearch']/../button/span[text()='Trigger location search']/..")
    private WebElement searchbutton;

    @FindBy(xpath="//a[text()='Homepage']/..")
    private WebElement homepagebutton;

    @FindBy(xpath="//img[@alt='UBS logo, to home page']")
    private WebElement ubslogo;


    public Locations(WebDriver driver)
    {
        super(driver);
    }

    public boolean VerifyLocationsHeader()
    {
        return this.headerlocations.isDisplayed();
    }

    public boolean VerifyLocationsMap()
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='loFi-map']")));
        return this.maplocations.isDisplayed();

    }

    public void Search_Location(String location)
    {
        this.searchbox.clear();
        this.searchbox.sendKeys(location);
        this.searchbutton.click();
    }

    public boolean Check_Location(String location)
    {
        //driver.switchTo().frame(0);
        wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@id,'loFi-poi__results__')]")));
        this.maplocations.isDisplayed();
        boolean test = driver.findElement(By.xpath("//h2[text()='"+location+"']")).isDisplayed();
        //driver.switchTo().defaultContent();
        return test;
    }

    public MainPage Homepage()
    {
        this.ubslogo.click();
        //this.homepagebutton.isDisplayed();
        //this.homepagebutton.click();
        driver.get("https://www.ubs.com"); //TODO interact with the home button, currently element not interactable
        return new MainPage(driver);

    }
}
