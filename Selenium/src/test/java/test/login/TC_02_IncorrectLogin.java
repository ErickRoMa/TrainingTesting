package test.login;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods.variablesGlobales;
import driverSetup.DriverSetup;
import navPages.LoginPage;

public class TC_02_IncorrectLogin {
	
	WebDriver driver = DriverSetup.setupDriver();
	
	LoginPage loginPage = new LoginPage(driver);
	
	@BeforeTest
	public void StartWebDriver() {
		driver.get(variablesGlobales.HOME_PAGE);
		driver.manage().window().maximize();
	}
	
  @Test
  public void TC_02() {
	  boolean isIncorrect = loginPage.LoginError(variablesGlobales.USER_ADMIN, variablesGlobales.PASSWORD_ADMIN+"A");
	  Assert.assertTrue(isIncorrect);
  }
  
  @AfterTest
  public void CloseDriver() {
	  driver.quit();
  }
}
