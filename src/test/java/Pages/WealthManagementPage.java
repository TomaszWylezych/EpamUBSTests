package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WealthManagementPage extends PageObject
{
    @FindBy(xpath="//h1[contains(text(),'Your life goals')]")
    private WebElement LifeGoalHeader;

    public WealthManagementPage(WebDriver driver)
    {
        super(driver);

    }

    public boolean VerifyYourLifeGoals()
    {
        return this.LifeGoalHeader.isDisplayed();
    }

}
