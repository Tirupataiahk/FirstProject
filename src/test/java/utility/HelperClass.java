package utility;

import java.io.File;

//import net.sourceforge.cobertura.javancss.FileUtil;


import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//import com.sun.jna.platform.FileUtils;

public class HelperClass {
	
	public static String captureScreanshot(WebDriver driver, String screenshotName){
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String destination="./Screanshots/"+screenshotName+System.currentTimeMillis()+".png";
		
		try {
			FileUtils.copyFile(src, new File(destination));
			
		} catch (IOException e) {
			
			System.out.println("Failed to capture screan shot"+e.getMessage());
			
		}
		
		return destination;
	}

}
