package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyHome_Report {

	WebDriver driver;
	
	@BeforeTest
	public void setUP(){
		
		driver = BrowserFactory.getBrowser("IE");

		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
	}
			
	@Test
	public void testLoginPage() {

		LoginPage Login = PageFactory.initElements(driver, LoginPage.class);

		String title = Login.getApplicationTitle();
		
		Assert.assertTrue(title.contains("google"));
		System.out.print("a");
		

	}
	
	@AfterMethod
	public void TearDown(){
		
		BrowserFactory.closeBrowser(driver);
		
	}

}
