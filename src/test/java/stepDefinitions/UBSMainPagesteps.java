package stepDefinitions;

import Pages.ContactUsPage;
import Pages.MainPage;
import Pages.WealthManagementPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class UBSMainPagesteps {
    WebDriver driver;
    MainPage mainpage;
    WealthManagementPage wealthmanagementpage;
    ContactUsPage contactuspage;

    @Given("Start chrome browser")
    public void start_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_1.exe"); //TODO create class that takes parameter what browser to start, return driver with the proper browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("Open home page")
    public void open_home_page()
    {
        this.mainpage = new MainPage(driver);
    }

    @Then("Verify main page loaded")
    public void VerifyMainPage()
    {

        Assert.assertTrue(mainpage.LogoPresent());

    }

    @When("Go To Wealth Management")
    public void Open_Wealth_Management() //TODO add string parameter to which one is opened, current your life goals
    {
        this.wealthmanagementpage = new WealthManagementPage(driver);
    }

    @Then("Verify Wealth Management page loaded")
    public void VerifyWealthManagementPage() {
        Assert.assertTrue(wealthmanagementpage.VerifyYourLifeGoals());
    }

    @And("Close")
    public void close()
    {
        mainpage = null;
        wealthmanagementpage = null;
        driver.quit();
    }

    @When("Go To Contact Us")
    public void Open_Contact()
    {
        this.contactuspage = new ContactUsPage(driver);
    }

    @Then("Verify Contact Us page loaded")
    public void VerifyContactPage()
    {
        Assert.assertTrue(contactuspage.VerifyContactUs());
    }

}