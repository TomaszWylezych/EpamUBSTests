package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage
{
    WebDriver driver;
    String current_lang;
    WebDriverWait wait;

    public MainPage(WebDriver driver) //default english
    {

        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.driver.get("https://www.ubs.com/global/en.html");
        current_lang = "EN";
        this.wait = new WebDriverWait(this.driver, 10);
        this.driver.switchTo().frame(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Set preferences']")));
        this.driver.findElement(By.xpath("//span[text()='Set preferences']")).click();
        this.driver.switchTo().defaultContent();
    }
    /*public MainPage(WebDriver driver, String lang)
    {
        this.driver=driver;
        this.driver.get("https://www.ubs.com/global/en.html");
        ChangeLanguage(lang);
    }*/

    public void ChangeLanguage(String lang)
    {
        if(current_lang != lang)
        {
            driver.findElement(By.xpath("//a[@lang="+lang+"]")).click();
        }
    }

    public boolean LogoPresent()
    {
        return driver.findElement(By.xpath("//img[@class='logo__img']")).isDisplayed();
    }
}
