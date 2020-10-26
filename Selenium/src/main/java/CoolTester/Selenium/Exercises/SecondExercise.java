package CoolTester.Selenium.Exercises;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondExercise {

	public static void main(String[] args) {
		//Drivert Path must have execution grant throught out "chmod 777 + filename"
        //Driver Path Creation
        String driverPath = System.getProperty("user.dir"); //Paths.get("").toAbsolutePath().toString() ;
        	   driverPath += File.separator + "driver";
               driverPath += File.separator + "chromedriver";

        System.setProperty("webdriver.chrome.driver", driverPath);
        
        //Create Driver Instance 
        WebDriver driver= new ChromeDriver();
        driver.get("https://demo.guru99.com/popup.php");
                
        try {
                            	
            String pathTab = driver.getWindowHandle();
            System.out.println(pathTab);
            
            Thread.sleep(3000);
            
            WebElement clickHere = driver.findElement(By.xpath("//*[contains(@href,'popup.php')]"));
            clickHere.click();
            
            Set<String> ventanasAbiertas = driver.getWindowHandles();
            System.out.println(ventanasAbiertas);
            
            for(String newTb : ventanasAbiertas) {
            	if(!pathTab.contentEquals(newTb))
            	{
            		driver.switchTo().window(newTb); 
            		break;
            	}
            }
            
            WebElement emailTx = driver.findElement(By.name("emailid"));
            emailTx.sendKeys("test@test.com");
            
            driver.switchTo().window(pathTab);
            
            
            Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("--> " + e.getMessage());
		}finally {			 
			  /*driver.close();
		      driver.quit();	*/	      
		}
	}

}
