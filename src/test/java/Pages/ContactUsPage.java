package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ContactUsPage
{
    WebDriver driver;
    WebDriverWait wait;

    public ContactUsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.driver.findElement(By.xpath("//span[contains(text(),'Contact')]")).click();
        this.wait = new WebDriverWait(this.driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Tools & Services']/..//ul[@aria-hidden='false']")));
        this.driver.findElement(By.xpath("//a[contains(text(),'Contact us')]")).click();

    }

    public boolean VerifyContactUs()
    {
        return driver.findElement(By.xpath("//h1[contains(text(),'Contact us')]")).isDisplayed();
    }

}
