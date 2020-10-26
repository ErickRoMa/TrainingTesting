package navPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
  /*Login Page Objects / Web Elements*/
	@FindBy(id="txtUsername")
	private WebElement userNameTxt;
	@FindBy(id="txtPassword")	
	private WebElement passwordTxt;
	@FindBy(id="btnLogin")
	private WebElement btnLogin;
	@FindBy(xpath ="//*[@id=\"spanMessage\"]")
	private WebElement lblError;
	
	public void Login(String user,String password) {
		
		userNameTxt.sendKeys(user);
		passwordTxt.sendKeys(password);
		btnLogin.click();		
	}
	
	public Boolean LoginError(String user,String password) {
		
		userNameTxt.sendKeys(user);
		passwordTxt.sendKeys(password);
		btnLogin.click();
		boolean errMsg =  lblError.getText().contains("Invalid credentials");
				
		return errMsg;
	}
}
