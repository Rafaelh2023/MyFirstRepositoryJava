package Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
/**
    private WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }**/
    public static class UtilsDriver {
        public static String BASE_URL = "https://formy-project.herokuapp.com/form";
        public static String CHROME_DRIVER_LOCATION = "resources/driver/chromedriver.exe";
        public static String EDGE_DRIVER_LOCATION = "resources/driver/msedgedriver_110.exe";
        public static String FIREFOX_DRIVER_LOCATION = "resources/driver/geckodriver.exe";
        public static String DIRECTORY_SCREEN_SHOTS  = "Report/";
        public static String DIRECTORY_REPORT = "Report/form.html";

    }
}
