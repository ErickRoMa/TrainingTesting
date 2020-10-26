package CoolTester.Selenium.Exercises;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class HardTest  {
	@Test
	public void assertEquals() {
		int a =10;	
		int b =10;
		Assert.assertEquals(a, b,"Los numeros son iguales");
	}
	@Test
	public void assertNotEquals() {
		int a =10;	
		int b =10;
		Assert.assertNotEquals(a, b,"Los numeros son iguales");
	}
	@Test
	public void assertTrue() {
		int a =10;	
		int b =10;
		Assert.assertTrue(a==b);
	}
	@Test
	public void assertFalse() {
		int a =10;	
		int b =10;
		Assert.assertFalse(a==b);
	}
	
	@Test
	public void verificarTituloPagina() {
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
        
       // Assert.assertEquals(pageTitle, expectedTitle);
            
		boolean res = pageTitle.contains(expectedTitle);
		   
		Assert.assertTrue(res);
		    
		   
	    /*driver.quit();
	    driver.close();*/
	}
}
