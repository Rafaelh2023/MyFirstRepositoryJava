package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
    private static WebDriver driver;

    public WaitTypes(WebDriver driver){
        this.driver = driver;
    }

    public static class WaitElement{
    public static void waitForElement(WebElement element, int timeout){
        try{
            System.out.println("Waiting for max:: " + timeout + "seconds for element to be available");
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("Element appeared on the web page");

        }catch (Exception e){
            System.out.println("Element not appeared on the web page");
        }

    }
    }
}
