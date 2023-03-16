package Utilities;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {

    public static void takeScreenShots(WebDriver driver) throws IOException {
        String fileName = "Test_" + getRandomName(3) + ".png";
        String directory = Base.UtilsDriver.DIRECTORY_SCREEN_SHOTS;
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
    }
    public static String getRandomName(int length){
        StringBuilder sb = new StringBuilder();
        String characters = "aeiou1234567890";
        for(int i=0; i<length; i++){
            int index = (int)(Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}
