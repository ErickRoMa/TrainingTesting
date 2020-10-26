package test.login;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import commonMethods.variablesGlobales;
import driverSetup.DriverSetup;
import navPages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;


public class TC_05_LoginParameter {

	WebDriver driver = DriverSetup.setupDriver();
	
	LoginPage loginPage = new LoginPage(driver);
	
	@Test
    @Parameters({"user","password"})
  public void TC_05(String user, String password) {
		loginPage.Login(user, password);
  }
	
  @BeforeMethod
  public void startWebDriver() {
	  driver.get(variablesGlobales.HOME_PAGE);
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void closeDriver() {
	  driver.quit();
  }

}
