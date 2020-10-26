package test.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods.CommonMethods;
import commonMethods.variablesGlobales;
import driverSetup.DriverSetup;
import navPages.LoginPage;

public class TC_01_CorrectLogin {
	
	WebDriver driver = DriverSetup.setupDriver();
	
	LoginPage loginPage = new LoginPage(driver);
	
	@BeforeTest
	public void StartWebDriver() {
		driver.get(variablesGlobales.HOME_PAGE);
		driver.manage().window().maximize();
	}
	
  @Test
  public void TC_01() {
	  loginPage.Login(variablesGlobales.USER_ADMIN, variablesGlobales.PASSWORD_ADMIN);	  
  }
  
  @AfterTest
  public void CloseDriver() {
	  CommonMethods.takeScreenshot(driver, "TC_01_CorrectLogin");
	  driver.quit();
  }
}
