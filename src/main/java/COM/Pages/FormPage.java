package COM.Pages;

import COM.Readfromfile.Readfromjson;
import COM.SeleniumActionS.SeleniumAction;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class FormPage {
    public WebDriver driver;
    //JavascriptExecutor jse;
    SeleniumAction seleniumActions;
    Readfromjson readfromjson;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumAction(driver);
        readfromjson=new Readfromjson();
        // jse = (JavascriptExecutor) driver;
    }


    @FindBy(xpath = "//li[@class='rootdropdownmenuitem']//a[normalize-space()='Contact']")
    WebElement contact;

    @FindBy(name = "name")
    WebElement nameInputBox;

    @FindBy(name = "email")
    WebElement emailInputBox;

    @FindBy(id = "139area")
    WebElement messageBox;
    @FindBy(xpath = "//input[@class='File']")
    WebElement attachButton;
    @FindBy(xpath = "//div[@class='CheckBox']")
    WebElement checkBox;
    @FindBy(xpath = "//div[@class='buttonIcon']")
    WebElement sbutton;
    @FindBy(xpath = "//div[@class='SuccessMessage']")
    WebElement SuccessMessage;

    public void clickOnContact() {
        seleniumActions.clickOnElement(contact);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
    }

    //to send the data into form
    public void formfil(String Name,String Emil,String Message) throws IOException, ParseException, InterruptedException {
        Thread.sleep(3000);
        //for josn data
//        seleniumActions.enterValueOnTextField(nameInputBox,readfromjson.readFile("Name"));
//        seleniumActions.enterValueOnTextField(emailInputBox,readfromjson.readFile("Email"));
//        seleniumActions.enterValueOnTextField(messageBox,readfromjson.readFile("Message"));
//
        seleniumActions.enterValueOnTextField(nameInputBox,"S1");
        seleniumActions.enterValueOnTextField(emailInputBox,Emil);
        seleniumActions.enterValueOnTextField(messageBox,Message);
        seleniumActions.clickOnElement(checkBox);
        seleniumActions.clickOnElement(sbutton);
    }
    //to Verifi successmeessage
    public boolean successMessageVerification()
    {
       return SuccessMessage.isDisplayed();
    }
}


