package seleniumHackathon;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class currenyConvertTestPage extends currencyConvertBaseTest{
	
	@Test
	public void amazonKindle() {
		WebDriver driver = getBrowser("chrome" );
		currencyConvertBasePage cp =new currencyConvertBasePage(driver);
		
		Assert.assertTrue(cp.launchApp(driver, "https://www.xe.com/"), "App should be launched");
		Assert.assertTrue( cp.selectCountryFrom(),"SHould select country-from list" );
		Assert.assertTrue(cp.selectCountryUSA(),"USA should be selected");
		Assert.assertTrue(cp.selectCountryTo(),"SHould select country-to list");
		Assert.assertTrue(cp.selectCountryIndia(),"India shoukd be selected");
		Assert.assertTrue(cp.clickConvertButton(),"Convertion should be displayed");
	}
	

}
