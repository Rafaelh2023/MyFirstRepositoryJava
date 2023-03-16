package Test;

import Step.FormSteps;
import Utilities.Base;
import Utilities.Screenshots;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FormTest {

    private WebDriver driver;
    private FormSteps st;
    ExtentReports report;
    ExtentTest test;

    @BeforeSuite
    public void openApp() throws IOException {
        report = new ExtentReports(Base.UtilsDriver.DIRECTORY_REPORT);
        test = report.startTest("Type information in Form and Submit");
        test.log(LogStatus.INFO, "Browser Started");
        System.setProperty("webdriver.edge.driver", Base.UtilsDriver.EDGE_DRIVER_LOCATION);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser Maximized");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Base.UtilsDriver.BASE_URL);
        test.log(LogStatus.INFO, "Web application Opened");
        st = new FormSteps(driver);
        Screenshots.takeScreenShots(driver);
    }

    @Test(testName = "Send Form")
    public void submitForm() throws IOException {
        st.enterFirstName();
        test.log(LogStatus.INFO, "Enter First Name");
        st.enterLastName();
        test.log(LogStatus.INFO, "Enter Last Name");
        st.enterJobTitle();
        test.log(LogStatus.INFO, "Enter Job Title");
        st.clickOptionCollege();
        test.log(LogStatus.INFO, "Click in Highest level of Education");
        st.clickOptionSex();
        test.log(LogStatus.INFO, "Click on Sex option");
        st.selectJobExperience();
        test.log(LogStatus.INFO, "Select Job Experience");
        st.enterDate();
        test.log(LogStatus.INFO, "Enter Date");
        st.clickSubmit();
        test.log(LogStatus.INFO, "Click in Button Submit");
        Screenshots.takeScreenShots(driver);
    }
    @Test(testName = "Validate Message")
    public void validateMessage() throws IOException {
        st.validateMsg();
        test.log(LogStatus.PASS, "Verified Message: The form was successfully submitted!");
        Screenshots.takeScreenShots(driver);
        /**
        if(testResult.getStatus() == ITestResult.SUCCESS){
            Screenshots.takeScreenShots(driver, testResult.getName());
           // String imagePath = test.addScreenCapture(path);

        }**/
    }
    @AfterSuite
    public void closeApp() throws InterruptedException {
        Thread.sleep(20);
        report.endTest(test);
        report.flush();
        driver.quit();
    }
}
