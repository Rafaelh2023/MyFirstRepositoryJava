package Test;
import Step.FormSteps;
import Utilities.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class FormTest {

    WebDriver driver;
    FormSteps st;
    @BeforeTest
    public void openApp(){

        /**
            System.setProperty("webdriver.chrome.driver", "resources/driver/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", Base.UtilsDriver.CHROME_DRIVER_LOCATION);
            driver = new ChromeDriver();
         **/
        System.setProperty("webdriver.edge.driver", Base.UtilsDriver.EDGE_DRIVER_LOCATION);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(Base.UtilsDriver.BASE_URL);
        st = new FormSteps(driver);
    }

    @Test(testName = "Send Form")
    public void submitForm(){
        st.enterFirstName();
        st.enterLastName();
        st.enterJobTitle();
        st.clickOptionCollege();
        st.clickOptionSex();
        st.selectJobExperience();
        st.enterDate();
        st.clickSubmit();
    }

    @Test(testName = "Validate Message")
    public void validateMessage(){
        st.validateMsg();
    }

    @AfterTest
    public void closeApp() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
