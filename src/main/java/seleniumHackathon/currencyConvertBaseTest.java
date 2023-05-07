package seleniumHackathon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class currencyConvertBaseTest {
	
	public static WebDriver getBrowser(String sBrowserName) {
		WebDriver driver = null;
		String browserName=sBrowserName.toLowerCase();
		
		switch(browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		}
		
		
		return driver;
	}

}
