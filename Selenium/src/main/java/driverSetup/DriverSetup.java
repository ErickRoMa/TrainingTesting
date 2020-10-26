package driverSetup;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {

		public static WebDriver setupDriver (){
			//Drivert Path must have execution grant throught out "chmod 777 + filename"
	        //Driver Path Creation
	        String driverPath = System.getProperty("user.dir"); //Paths.get("").toAbsolutePath().toString() ;
	        	   driverPath += File.separator + "driver";
	               driverPath += File.separator + "chromedriver";

	        System.setProperty("webdriver.chrome.driver", driverPath);
	        
	        //Create Driver Instance 
	        WebDriver driver= new ChromeDriver();
	        
	        return driver;
		}
}
