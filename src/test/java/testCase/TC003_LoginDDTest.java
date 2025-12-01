package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_LoginDDTest extends BaseClass {
	
	@Test(dataProvider="LoginData" ,dataProviderClass=DataProviders.class,groups="DataDriven")//getting data provider from different class
	public void verify_loginDDT(String email,String pwd,String exp)
	{
		logger.info("***** Starting TC003_LoginDDT... *******");
		
		try
		{
		HomePage hp= new HomePage(driver);
		hp.MyAccount();
		hp.MyLogin();
		
		//Login Page
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccount
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean tergetPage=macc.isMyAccountPageExists();
		
		/*Data is Valid--Login success-testPass-logout
		 * Data is Valid --login failed -test fail
		 * 
		 * Data is Invalid-login Success -test fail-logout
		 * Data is Invalid -login failed -test pass 
		 */
		
		
		//1st condition
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(tergetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true); //Assertion always should be after the action,bcoz after assertion no statements will be executed
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		//2nd Condition
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(tergetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
		}
			else
			{
				Assert.assertTrue(true);
			}
	}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***** Starting TC003_LoginDDT... *******");
	
	}	
	

}
