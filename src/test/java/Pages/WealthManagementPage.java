package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WealthManagementPage
{
    WebDriver driver;
    WebDriverWait wait;

    public WealthManagementPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.driver.findElement(By.xpath("//a[contains(text(),'Wealth Management')]")).click();
        this.wait = new WebDriverWait(this.driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@aria-hidden='false']")));
        this.driver.findElement(By.xpath("//a[contains(text(),'Your life goals')]")).click();
    }

    public boolean VerifyYourLifeGoals()
    {
        return driver.findElement(By.xpath("//h1[contains(text(),'Your life goals')]")).isDisplayed();
    }

}
