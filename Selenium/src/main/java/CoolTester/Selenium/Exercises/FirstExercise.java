package CoolTester.Selenium.Exercises;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstExercise {

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
        
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        
        try {
        	username.sendKeys("Admin");
            Thread.sleep(3000);
            password.sendKeys("admin123");
            Thread.sleep(3000);
            btnLogin.click();
            Thread.sleep(3000);
            
            WebElement btnDirectory = driver.findElement(By.id("menu_directory_viewDirectory"));
            btnDirectory.click();
            
            WebElement btnEmpName = driver.findElement(By.id("searchDirectory_emp_name_empName"));
            btnEmpName.sendKeys("Robert");
            Select selJobTitle = new Select( driver.findElement(By.id("searchDirectory_job_title")));
            selJobTitle.selectByVisibleText("Sales Manager");
            Select selLocation = new Select( driver.findElement(By.id("searchDirectory_location")));
            selLocation.selectByVisibleText("  United States");
            
            WebElement btnSearch = driver.findElement(By.id("searchBtn"));
            btnSearch.click();
            Thread.sleep(3000);
                    	
            List<WebElement> itemsMenu = driver.findElements(By.xpath("//*[@class='firstLevelMenu']/b"));
             
            System.out.println("Elements" + itemsMenu.size());
            System.out.println("First Element" + itemsMenu.get(0).getText());
            System.out.println("Second Element" + itemsMenu.get(1).getText());
            
            for (int i = 0; i < itemsMenu.size(); i++) {
				System.out.println(" Los Menus son : " + itemsMenu.get(i).getText());
			}
            Thread.sleep(3000);
            
            WebElement tblResult = driver.findElement(By.id("resultTable"));
            List<WebElement> links = tblResult.findElements(By.tagName("li"));
            
             WebElement li= null;
             String liText ="";
             String strFndName = "Robert Craig"; 
            for (int i = 0; i < links.size(); i++) {
				li = links.get(i);
				liText = li.getText();
								
				if(liText.contains(strFndName))
				{					
					System.out.println("Nombre " + strFndName);
					break;
				}
				
				liText="";
			}
            System.out.println(liText+" ; "+strFndName);
            if(liText.contains(strFndName))
            	System.out.println("Contiene el nombre de " + strFndName);
            else 
            	System.out.println("No contiene el nombre de " + strFndName);
            
            Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("--> " + e.getMessage());
		}finally {			 
			  driver.close();
		      driver.quit();    
		}
	}

}
