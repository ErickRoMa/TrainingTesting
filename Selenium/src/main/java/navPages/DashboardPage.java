package navPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
  /*Login Page Objects / Web Elements*/
	@FindBy(id="welcome")
	private WebElement welcomeHref;
	@FindBy(xpath="//*[@id=\"welcome-menu\"]/ul/li[2]/a")	
	private WebElement logOutOption;
	@FindBy(id="txtUsername")	
	private WebElement txtUserName;
	
	public boolean logout() {
		welcomeHref.click();
		logOutOption.click();		
		boolean isDisplayed =		txtUserName.isDisplayed();
		
		return isDisplayed;
	}
	
}
