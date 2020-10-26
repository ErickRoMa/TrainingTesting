package CoolTester.Selenium.Exercises;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SoftTest  {
	SoftAssert softAssert = new SoftAssert();
	@Test
	public void softAssertEquals() {
		int a=1;
		int b=10;
		int x=8;
		int y=8;
		
		softAssert.assertEquals(a,b);
		softAssert.assertEquals(x,y);
		
		softAssert.assertAll();
	}
	
	@Test
	public void softAssertDriver() {
		//Drivert Path must have execution grant throught out "chmod 777 + filename"
        //Driver Path Creation
        String driverPath = System.getProperty("user.dir"); //Paths.get("").toAbsolutePath().toString() ;
        	   driverPath += File.separator + "driver";
               driverPath += File.separator + "chromedriver";

        System.setProperty("webdriver.chrome.driver", driverPath);
        
        //Create Driver Instance 
        WebDriver driver= new ChromeDriver();
        
        //Create Driver Instance         
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        String pageTitle = driver.getTitle();
        String expectedTitle = "OrangeHRM";
        String badTitle = "OrangeHR";
        
        softAssert.assertEquals(pageTitle,expectedTitle);
        softAssert.assertEquals(pageTitle,badTitle);
        softAssert.assertAll();
	}
}
