package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;
import utility.HelperClass;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyHome {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeTest
	public void setUP(){
		report=new ExtentReports("./Reports/LoginPageReportReport.html",true);
		
		logger=report.startTest("Verify Test Login");
		
		driver = BrowserFactory.getBrowser("IE");

		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.log(LogStatus.PASS, "Application Up and Running");
		
	}
			
	@Test
	public void testLoginPage() {

		LoginPage Login = PageFactory.initElements(driver, LoginPage.class);

		String title = Login.getApplicationTitle();
		
		Assert.assertTrue(title.contains("google"));
		
		logger.log(LogStatus.INFO, "Home Page displayed Successfully.");
		
			}
	
	@AfterMethod
	public void TearDown(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE){
			
			String path=HelperClass.captureScreanshot(driver, result.getName());
			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
		
	}

}
