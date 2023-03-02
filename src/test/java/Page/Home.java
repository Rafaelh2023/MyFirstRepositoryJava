package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

    public Home(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebDriver driver;

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "job-title")
    public WebElement jobTitle;

    @FindBy(id = "radio-button-2")
    public WebElement rbtOptionCollege;

    @FindBy(id = "checkbox-1")
    public WebElement sexOptionMale;

    @FindBy(id = "select-menu")
    public WebElement jobForExperience;

    @FindBy(xpath = "//input[@id='datepicker']")
    public WebElement date;

    @FindBy(xpath = "//a[contains(@class, 'btn btn-lg btn-primary')]")
    public WebElement btnSubmit;

    @FindBy(xpath = "//div[contains(@class, 'alert alert-success')]")
    public WebElement assertion;



}
