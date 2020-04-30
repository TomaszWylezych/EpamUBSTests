package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ContactUsPage extends PageObject
{
    WebDriverWait wait;

    @FindBy(xpath="//h1[contains(text(),'Contact us')]")
    private WebElement contactusheader;

    public ContactUsPage(WebDriver driver)
    {
        super(driver);
    }

    public boolean VerifyContactUs()
    {
        return this.contactusheader.isDisplayed();

    }

}
