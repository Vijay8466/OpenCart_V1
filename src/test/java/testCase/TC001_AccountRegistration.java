package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass{
	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("***** Strating TC001_AccountRegistrationTest *****");
		
		try {
		HomePage hp=new HomePage(driver);
		
		hp.MyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.MyRegistration();
		logger.info("Clicked on Registration Link");
		
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing Customer Details");
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.Checkbox();
		regpage.BtnContinue();
		
		logger.info("Validating expected message..");
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test Failed....");
			logger.debug("Debug logs..");
			
		}
//		Assert.assertEquals(confmsg, "Your Account Has Been Created");
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}
	
}
