package COM.SeleniumActionS;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class SeleniumAction {
    public static WebDriver driver;

    public SeleniumAction(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * click on elements
     *
     * @param element
     */
    public static boolean clickOnElement(WebElement element) {
        boolean flag = false;
        try {
            element.click();
            flag = true;
        } catch (NoSuchElementException | ElementNotInteractableException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (StaleElementReferenceException see) {
            System.out.println(see.toString());
            flag = false;
        }
        return flag;
    }

    public static boolean hoverOnElements(WebElement element) {
        boolean flag = false;
        Actions action = new Actions(driver);
        try {
            action.moveToElement(element).build().perform();
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (ElementNotInteractableException eic) {
            System.out.println(eic.toString());
            flag = false;
        }
        return flag;
    }



    /**
     * enter value on text field
     *
     * @Param element
     * @Param data
     */
    public boolean enterValueOnTextField(WebElement element, String data) {
        boolean flag = false;
        try {
            element.sendKeys(data);
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (StaleElementReferenceException see) {
            System.out.println(see.toString());
            flag = false;
        } catch (ElementNotInteractableException eie) {
            System.out.println(eie.toString());
            flag = false;
        }
        return flag;
    }


    /**
     * click on elements
     *
     * @param by
     * @return
     */
    public boolean clickOnElement(By by) {
        try {
            driver.findElement(by).click();
            return true;
        } catch (Exception e) {

            return false;
        }
    }
}

