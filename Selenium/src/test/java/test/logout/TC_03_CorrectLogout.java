package test.logout;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods.variablesGlobales;
import driverSetup.DriverSetup;
import navPages.LoginPage;
import navPages.DashboardPage;

public class TC_03_CorrectLogout {
	WebDriver driver = DriverSetup.setupDriver();
	
	LoginPage loginPage = new LoginPage(driver);
	DashboardPage logoutPage = new DashboardPage(driver);
	
	@BeforeTest
	public void StartWebDriver() {
		driver.get(variablesGlobales.HOME_PAGE);
		driver.manage().window().maximize();
	}
	
  @Test
  public void TC_01() {
	  loginPage.Login(variablesGlobales.USER_ADMIN, variablesGlobales.PASSWORD_ADMIN);
	  boolean isLoggedout =	  logoutPage.logout();
	  Assert.assertTrue(isLoggedout);
  }
  
  @AfterTest
  public void CloseDriver() {
	  driver.quit();
  }
}
