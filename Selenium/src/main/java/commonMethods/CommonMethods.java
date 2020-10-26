package commonMethods;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class CommonMethods {
     public static void takeScreenshot(WebDriver driver,String testCaseName) {
    	 File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	 String screenShotPath = Paths.get("").toString() + File.separator + "test_output" + File.separator + testCaseName;
    	try {
    		FileHandler.createDir(new File(screenShotPath));
    		FileHandler.copy(scrFile, new File(screenShotPath + File.separator + "evidencia.png"));			
		} catch (IOException e) {
			e.printStackTrace();
		}
     }
}
