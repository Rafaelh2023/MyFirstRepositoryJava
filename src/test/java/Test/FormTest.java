package Test;


import Step.FormSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FormTest {

    WebDriver driver;

    @BeforeTest
    public void openApp(){
        System.setProperty("webdriver.chrome.driver", "C://Training//chromedriver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://formy-project.herokuapp.com/form");
    }

    @Test(testName = "SendForm")
    public void submitForm(){
        FormSteps st = new FormSteps(driver);
        st.enterFirstName();
        st.enterLastName();
        st.enterJobTitle();
        st.clickOptionCollege();
        st.clickOptionSex();
        st.selectJobExperience();
        st.enterDate();
        st.clickSubmit();
        st.validateAssertion();
    }

    @AfterTest
    public void closeApp(){
       driver.close();
    }

}
