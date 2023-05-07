package seleniumHackathon;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class amazonCartTest extends baseTestAmazonCart {

	@Test
	public void AmazonSearchKindle() throws InterruptedException {

		WebDriver driver = baseTestAmazonCart.getBrowserType("chrome", false);
		amazonCartPage acp = new amazonCartPage(driver);

		Assert.assertTrue(acp.launchApp(driver, "https://www.amazon.com/"), "Amazon page should be displayed");
		Assert.assertTrue(acp.enterSearchText("Kindle"), "Product list page should be displayed");
		Assert.assertTrue(acp.selectAmazonChoiceKindle(), "Amazon choice product page should be displayed");
		Assert.assertTrue(acp.addToCart(), "Product should be added to cart");
		acp.closePopup();
		Assert.assertTrue(acp.goToCart(driver), "shopping cart page should be displayed");
		Assert.assertTrue(acp.validateProduct());

	}

}
