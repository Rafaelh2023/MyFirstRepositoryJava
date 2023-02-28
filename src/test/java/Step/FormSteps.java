package Step;

import Page.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FormSteps extends Home {

    public FormSteps(WebDriver driver){
        super(driver);
    }

    public void enterFirstName(){
        String firstName = "Rafael";
        this.firstName.sendKeys(firstName);
    }

    public void enterLastName(){
        String lastName = "Hernandez";
        this.lastName.sendKeys(lastName);
    }

    public void enterJobTitle(){
        String jobTitle = "Testing";
        this.jobTitle.sendKeys(jobTitle);
    }

    public void clickOptionCollege(){
        rbtOptionCollege.click();
    }

    public void clickOptionSex(){
        sexOptionMale.click();
    }

    public void selectJobExperience(){
        String experience = "2-4";
        Select jobExperience = new Select(jobForExperience);
        jobExperience.selectByVisibleText(experience);
    }

    public void enterDate(){
        String date = "20/10/2019";
        this.date.sendKeys(date);
    }

    public void clickSubmit(){
        btnSubmit.click();
    }

    public void validateAssertion(){
        String result= "The form was successfully submitted!";
        Assert.assertEquals(assertion.getText(), result);
        System.out.println(assertion.getText());
    }
}
