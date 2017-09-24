package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(xpath = "//*[@type='email']")
	WebElement MailId;

	@FindBy(xpath = ".//*[@name='pass']")
	WebElement Password;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement Login;

	public void clickOnLogin() {

		MailId.sendKeys("tirupathit@gmail.com");

		Password.sendKeys("buchanna@1");

		Login.click();

	}

	public String getApplicationTitle() {

		return driver.getTitle();

	}

}
