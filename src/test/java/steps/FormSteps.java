package steps;

import COM.Pages.FormPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class FormSteps {

    public FormPage formPage;
    public WebDriver driver;

//to intialaizedriver
    @Before
    public void intilaizeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(" https://compendiumdev.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
   // to kill the session
   @After
    public void killSession()
    {

        driver.quit();
    }

    @Given("homepage displayed")
    public void homepage_displayed() {

        System.out.println("homepage dispalyed successfully");
    }


    @When("click on contact")
    public void click_on_contact() {
        formPage=new FormPage(driver);
        formPage.clickOnContact();
    }

    @Then("fill the form")
    public void fill_the_form() throws IOException, ParseException, InterruptedException {
        System.out.println("Application Form Filling");
        formPage = new FormPage(driver);
        formPage.formfil("shankar","shankar458@gmail.com","this is shankar");

    }

    @Then("verify from submitted successfully message")
    public void verify_from_submitted_successfully_message() {
        System.out.println("verify submitted Successfully");
        formPage = new FormPage(driver);
        Assert.assertTrue(formPage.successMessageVerification());
    }


}
