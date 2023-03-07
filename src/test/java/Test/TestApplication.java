package Test;
import Step.FormSteps;
import Utilities.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class TestApplication {

    public WebDriver driver;
    FormSteps stepsAction;

    @Parameters("browser")

    @BeforeTest
    public void initBrowser(String browser){

        if(browser.equalsIgnoreCase("firefox")){

            System.setProperty("webdriver.gecko.driver", Base.UtilsDriver.FIREFOX_DRIVER_LOCATION);
            driver = new FirefoxDriver();

        }if(browser.equalsIgnoreCase("edge")){

            System.setProperty("webdriver.edge.driver", Base.UtilsDriver.EDGE_DRIVER_LOCATION);
            driver = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("chrome")){

            System.setProperty("webdriver.chrome.driver", Base.UtilsDriver.CHROME_DRIVER_LOCATION);
            driver = new ChromeDriver();
        }
        driver.get(Base.UtilsDriver.BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        stepsAction = new FormSteps(driver);
    }

    @Test(testName = "Submit Form")
    public void submitForm(){
        stepsAction.enterFirstName();
        stepsAction.enterLastName();
        stepsAction.enterJobTitle();
        stepsAction.clickOptionCollege();
        stepsAction.clickOptionSex();
        stepsAction.selectJobExperience();
        stepsAction.enterDate();
        stepsAction.clickSubmit();
    }

    @Test(testName = "Validate Message")
    public void validateMessage(){
        stepsAction.validateMsg();
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException{
        Thread.sleep(1000);
        driver.close();
    }
}