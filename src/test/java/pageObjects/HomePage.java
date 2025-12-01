package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	//constructor
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locator
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement linkMyAccount;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']") WebElement linkMyRegister;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement linkLogin;
	
	//Account Methods
	
	public void MyAccount()
	{
		linkMyAccount.click();
	}
	public void MyRegistration()
	{
		linkMyRegister.click();
	}
	public void MyLogin()
	{
		linkLogin.click();
	}
	

	

}
