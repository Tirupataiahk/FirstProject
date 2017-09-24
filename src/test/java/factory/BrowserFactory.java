package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	static WebDriver driver;

	public static WebDriver getBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", DataProviderFactory
					.getConfig().getChromePath());
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver", DataProviderFactory
					.getConfig().getIePath());

			driver = new InternetExplorerDriver();

		} else if (browserName.equalsIgnoreCase("fireFox")) {

			System.setProperty("webdriver.firefox.driver", DataProviderFactory
					.getConfig().getFirePath());

			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public static void closeBrowser(WebDriver ldriver) {

		driver.close();

	}
}
