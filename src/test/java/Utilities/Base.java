package Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
    /**
    public WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }**/
    public static class UtilsDriver {
        public static String BASE_URL = "https://formy-project.herokuapp.com/form";
        public static String CHROME_DRIVER_LOCATION = "resources/driver/chromedriver.exe";
        public static String EDGE_DRIVER_LOCATION = "resources/driver/msedgedriver_110.exe";
    }
}
