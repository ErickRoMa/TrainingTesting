package CoolTester.Selenium.Exercises;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FourExercise {

	public static void main(String[] args) {
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
        
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebElement username = driver.findElement(By.id("txtUsernam"));
        
        /*
        WebElement usernameExpTime =new WebDriverWait(driver,10)
        									.until(
        											ExpectedConditions.elementToBeClickable(By.id("txtUsername")));
        usernameExpTime.sendKeys("test");*/
        
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        							.withTimeout(Duration.ofSeconds(20))
        							.pollingEvery(Duration.ofSeconds(2))
        							.ignoring(NoSuchElementException.class);
        
        WebElement txtUserName = wait.until(
        		new Function<WebDriver,WebElement> () {
        				public WebElement apply(WebDriver driver) {
        					driver.navigate().refresh();
        					return driver.findElement(By.id("txtUsername"));
        					}        	 
        		});
        
		driver.close();
	    driver.quit();    		
	}

}
