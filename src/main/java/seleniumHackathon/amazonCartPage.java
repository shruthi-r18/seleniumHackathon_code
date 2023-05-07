package seleniumHackathon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amazonCartPage {

	public amazonCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "twotabsearchtextbox")
	public WebElement searchTextbox;

	@FindBy(id = "B08KTZ8249-amazons-choice-label")
	public WebElement chooseKindleAmazonChoice;

	@FindBy(id = "add-to-cart-button")
	public WebElement addToCartButton;

	@FindBy(xpath = "//span[@class=\"a-button a-button-span11 a-button-base a-button-small\"]")
	public WebElement goToCartButton;

	@FindBy(xpath = "//button[@class=\" a-button-close a-declarative\"]")
	public WebElement closePopup;
//	
	@FindBy(xpath = "//span[@class=\"a-size-base-plus a-color-base sc-product-title sc-grid-item-product-title\"]/span/span[@class=\"a-truncate-cut\"]")
	public WebElement verifyText;

	@FindBy(xpath = "//span[@id=\"productTitle\"]")
	public WebElement expectedText;

	public static String expected = "", actual = "";

	public boolean launchApp(WebDriver driver, String sURL) {
		boolean isLaunchApp = false;
		driver.get(sURL);
		String sActualURL = driver.getCurrentUrl();

		if (sURL.equals(sActualURL)) {
			isLaunchApp = true;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return isLaunchApp;
	}

	public boolean enterSearchText(String sText) {
		boolean isTextEntered = false;

		if (searchTextbox.isDisplayed()) {
			searchTextbox.sendKeys(sText);
			searchTextbox.submit();
			isTextEntered = true;
		} else {
			System.out.println("Enter text in the search box");
		}

		return isTextEntered;
	}

	public boolean selectAmazonChoiceKindle() throws InterruptedException {
		boolean isSelected = false;
		Thread.sleep(3000);
		if (chooseKindleAmazonChoice.isDisplayed()) {
			chooseKindleAmazonChoice.click();
			isSelected = true;
		} else {
			System.out.println("Amazon choice kindle not selected");
		}
		expected = expectedText.getText();
		return isSelected;
	}

	public boolean addToCart() throws InterruptedException {
		boolean isClicked = false;
		if (addToCartButton.isDisplayed()) {
			addToCartButton.click();
			isClicked = true;
		} else {
			System.out.println("Amazon choice kindle not selected");
		}
		return isClicked;
	}

	public void closePopup() {
		if (closePopup.isDisplayed()) {
			closePopup.click();
		}
	}

	public boolean goToCart(WebDriver driver) throws InterruptedException {
		boolean isClicked = false;
		WebDriverWait wait_elementLoad = new WebDriverWait(driver, 30);
		wait_elementLoad.until(ExpectedConditions.visibilityOf(goToCartButton));
		if (goToCartButton.isDisplayed()) {
			goToCartButton.click();
			isClicked = true;
		} else {
			System.out.println("Amazon choice kindle not selected");
		}
		actual = verifyText.getText();
		return isClicked;
	}

	public boolean validateProduct() {
		boolean isSame = false;

		if (actual.equals(expected)) {
			isSame = true;
		}
		return isSame;
	}

}
