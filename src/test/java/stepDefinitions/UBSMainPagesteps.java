package stepDefinitions;

import Pages.ContactUsPage;
import Pages.Locations;
import Pages.MainPage;
import Pages.WealthManagementPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UBSMainPagesteps {
    WebDriver driver;
    MainPage mainpage;
    WealthManagementPage wealthmanagementpage;
    ContactUsPage contactuspage;
    Locations locations;
    WebDriverWait wait;

    @Given("Start chrome browser")
    public void start_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_1.exe"); //TODO create class that takes parameter what browser to start, return driver with the proper browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("Open home page")
    public void open_home_page() throws InterruptedException {
        driver.get("https://www.ubs.com/global/en.html");
        mainpage = new MainPage(driver);

        wait = new WebDriverWait(driver, 10);
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Set preferences']")));
        driver.findElement(By.xpath("//span[text()='Set preferences']")).click();
        driver.switchTo().defaultContent();
    }

    @Then("Verify main page loaded")
    public void VerifyMainPage()
    {

        Assert.assertTrue(mainpage.LogoPresent());

    }

    @When("Go To Wealth Management")
    public void Open_Wealth_Management() //TODO add string parameter to which one is opened, current your life goals
    {
        wealthmanagementpage = mainpage.GotoWealthManagementPage();
    }

    @Then("Verify Wealth Management page loaded")
    public void VerifyWealthManagementPage() {
        Assert.assertTrue(wealthmanagementpage.VerifyYourLifeGoals());
    }

    @And("Close")
    public void close()
    {
        mainpage = null; //TODO a better cleanup
        wealthmanagementpage = null;
        locations = null;
        driver.quit();
    }

    @When("Go To Contact Us")
    public void Open_Contact()
    {
        contactuspage = mainpage.GoToContactUs();
    }

    @Then("Verify Contact Us page loaded")
    public void VerifyContactPage()
    {
        Assert.assertTrue(contactuspage.VerifyContactUs());
    }

    @When("Go to Locations")
    public void Open_Locations()
    {
        locations = this.mainpage.GoToLocations();

    }

    @Then("Verify Locations")
    public void verifyLocations()
    {

        Assert.assertTrue(locations.VerifyLocationsHeader());

        Assert.assertTrue(locations.VerifyLocationsMap());
    }

    @When("Search Wroclaw")
    public void search_Wroclaw()
    {
        locations.Search_Location("Wroclaw");
    }

    @Then("Wroclaw on map")
    public void wroclaw_on_map()
    {
        Assert.assertTrue(locations.Check_Location("Wroclaw"));
    }

    @When("Go To Homepage")
    public void go_To_Homepage()
    {
        mainpage = locations.Homepage();
    }

    @Then("Verify Homepage")
    public void verify_Homepage()
    {
        Assert.assertTrue(mainpage.LogoPresent());
    }
}