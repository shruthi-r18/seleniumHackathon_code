package seleniumHackathon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTestAmazonCart {

	public static WebDriver getBrowserType(String browserName, boolean headless) {

		String browser_Name = browserName.toLowerCase();
		WebDriver driver = null;
		switch (browser_Name) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			if (headless == true) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			if (headless == true) {
				EdgeOptions eo = new EdgeOptions();
				eo.setPageLoadStrategy("normal");
				eo.setCapability("--headless", true);
				driver = new EdgeDriver(eo);
			} else {
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			break;

		case "safari":
			WebDriverManager.chromedriver().setup();
			if (headless == true) {
				SafariOptions so = new SafariOptions();
				so.setCapability("--headless", true);
				driver = new SafariDriver(so);
			} else {
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			break;

		default:
			System.out.println("Enter valid browser");
		}
		return driver;
	}

}
